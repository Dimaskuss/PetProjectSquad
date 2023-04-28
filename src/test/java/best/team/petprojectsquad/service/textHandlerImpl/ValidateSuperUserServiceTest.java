package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import best.team.petprojectsquad.repository.SuperUserVolunteerRepository;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidateSuperUserServiceTest {
    @MockBean
    UserDataCache userDataCache;
    @MockBean
    SuperUserVolunteerRepository superUserVolunteerRepository;
    @MockBean
    UserFeedBackRepository userFeedBackRepository;
    @Autowired
    private ValidateSuperUserService validateSuperUserService;
    @Value("${super.user.password}")
    private String superUserPassword;
    private final long id = 123;
    @Test
    void getReplyMessageIfPasswordIsCorrect() throws URISyntaxException, IOException {
        List<BaseRequest> requestArrayList = new ArrayList<>();
            SendMessage sendMessage = new SendMessage(id, "Добро пожаловать!");
            SendMessage sendMessage1 = new SendMessage(id, "Ниже будет приведен список пользователей, которым нужна помощь");
            SendMessage sendMessage2 = new SendMessage(id, userFeedBackRepository.findAll().toString().replace("[", ""));
            requestArrayList.add(sendMessage);
            requestArrayList.add(sendMessage1);
            requestArrayList.add(sendMessage2);
        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", superUserPassword), Update.class);
        List<BaseRequest> replyMessage = validateSuperUserService.getReplyMessage(update.message());
        assertEquals(replyMessage.size(), requestArrayList.size());
        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
    }
}