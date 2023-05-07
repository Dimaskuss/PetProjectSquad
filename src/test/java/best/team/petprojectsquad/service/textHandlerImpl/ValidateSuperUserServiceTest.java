package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import best.team.petprojectsquad.repository.SuperUserVolunteerRepository;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidateSuperUserServiceTest {
    @Mock
    UserDataCache userDataCache;
    @Mock
    SuperUserVolunteerRepository superUserVolunteerRepository;
    @Mock
    UserFeedBackRepository userFeedBackRepository;
    @InjectMocks
    private ValidateSuperUserService validateSuperUserService;
    private String superUserPassword = "Volunteer123";
    private final long id = 123;

    @Test
    void getReplyMessageIfPasswordIsCorrect() throws URISyntaxException, IOException {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        List<UserFeedBack> feedBacksList = new ArrayList<>();
        feedBacksList.add(new UserFeedBack("+79211231212", id, "test"));

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", superUserPassword), Update.class);

        SendMessage sendMessage = new SendMessage(id, "Пароль введен некорректно");
        requestArrayList.add(sendMessage);

        List<BaseRequest> replyMessage = validateSuperUserService.getReplyMessage(update.message());

        assertEquals(replyMessage.size(), requestArrayList.size());
        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
    }
}