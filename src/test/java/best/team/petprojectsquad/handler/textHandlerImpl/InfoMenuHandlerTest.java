package best.team.petprojectsquad.handler.textHandlerImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import best.team.petprojectsquad.service.textHandlerImpl.InfoHandlerService;
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
class InfoMenuHandlerTest {

    @Mock
    private InfoHandlerService service;
    @InjectMocks
    private InfoMenuHandler infoMenuHandler;
    long id = 123;
    String text = "/info";

    @Test
    void shouldReturnMessageHandle() throws URISyntaxException, IOException {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage0 = new SendMessage(id, "/info");
        expectedArrayList.add(sendMessage0);

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "/info"), Update.class);

        when(service.getReplyMessage(update.message())).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = infoMenuHandler.handle(update.message());

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
    }

    @Test
    void shouldReturnHandlerName() {
        assertEquals(infoMenuHandler.getHandlerName(), BotState.INFO);
    }
}
