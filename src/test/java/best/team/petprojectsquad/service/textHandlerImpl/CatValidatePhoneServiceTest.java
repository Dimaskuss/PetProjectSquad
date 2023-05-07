package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import best.team.petprojectsquad.service.controllerServiceImpl.UserFeedBackControllerServiceImpl;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatValidatePhoneServiceTest {
    @Mock
    private UserDataCache userDataCache;
    @Mock
    private UserFeedBackControllerServiceImpl userFeedBackService;
    @InjectMocks
    private CatValidatePhoneService catValidatePhoneService;

    private String message = "+79356657658";
    private long id = 123;

    @Test
    void shouldReternNoCorrectPhoneGetReplyMessage() throws URISyntaxException, IOException {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Телефон написан некорректно, пришлите еще раз в формате +79315556677");
        requestArrayList.add(sendMessage);

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "test"), Update.class);

        List<BaseRequest> replyMessage = catValidatePhoneService.getReplyMessage(update.message());

        assertEquals(replyMessage.size(), requestArrayList.size());
        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
    }

    @Test
    void shouldReternRightCorrectPhonegetReplyMessage() throws URISyntaxException, IOException {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", message), Update.class);

        SendMessage sendMessage = new SendMessage(update.message().chat().id(), "Волонтер в ближайшее время Вам перезвонит.");
        requestArrayList.add(sendMessage);

        when(userFeedBackService.save(new UserFeedBack(
                update.message().text(),
                update.message().chat().id(),
                update.message().chat().firstName()
        ))).thenReturn(id);

        List<BaseRequest> replyMessage = catValidatePhoneService.getReplyMessage(update.message());

        assertEquals(replyMessage.size(), requestArrayList.size());
        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
    }
}