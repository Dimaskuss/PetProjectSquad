package best.team.petprojectsquad.handler.textHandlerImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.service.textHandlerImpl.ValidateSuperUserService;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidateSuperUserHandlerTest {
    @MockBean
    UserFeedBackRepository userFeedBackRepository;
    @InjectMocks
    ValidateSuperUserHandler validateSuperUserHandler;
    @Mock
    ValidateSuperUserService validateSuperUserService;
    String text = "/superUser";
    private long id = 123;
    @Test
    void handle() throws URISyntaxException, IOException {
        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage0 = new SendMessage(id, "/superUser");
        expectedArrayList.add(sendMessage0);

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "/superUser"), Update.class);

        when(validateSuperUserService.getReplyMessage(id,text)).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = validateSuperUserHandler.handle(update.message());

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getParameters(), expectedArrayList.get(0).getParameters());

    }

    @Test
    void getHandlerName() {
        assertEquals(validateSuperUserHandler.getHandlerName(), BotState.VALIDATE_VOLUNTEER);
    }
}