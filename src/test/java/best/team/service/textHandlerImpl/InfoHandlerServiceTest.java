package best.team.service.textHandlerImpl;

import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import best.team.petprojectsquad.service.textHandlerImpl.InfoHandlerService;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class InfoHandlerServiceTest {


    private InfoHandlerService infoHandlerService = new InfoHandlerService();
    long id = 123;
    String text = "/info";

    @Test
    void shouldReturnReplyMessage() throws URISyntaxException, IOException {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img_1.png"));
        expectedArrayList.add(sendMessage);
        expectedArrayList.add(sendPhoto);

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "/info"), Update.class);

        List<BaseRequest> actualList = infoHandlerService.getReplyMessage(update.message());

        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(1).getClass(), expectedArrayList.get(1).getClass());

        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(1).getParameters().get("chat_id"),expectedArrayList.get(1).getParameters().get("chat_id"));
    }
}
