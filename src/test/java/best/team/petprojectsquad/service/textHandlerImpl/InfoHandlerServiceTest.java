package best.team.petprojectsquad.service.textHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class InfoHandlerServiceTest {


    private InfoHandlerService infoHandlerService = new InfoHandlerService();
    long id = 1005223990L;
    String text = "/info";

    @Test
    void shouldReturnReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img_1.png"));
        expectedArrayList.add(sendMessage);
        expectedArrayList.add(sendPhoto);

        List<BaseRequest> actualList = infoHandlerService.getReplyMessage(id, text);

        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(1).getClass(), expectedArrayList.get(1).getClass());

        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(1).getParameters().get("chat_id"),expectedArrayList.get(1).getParameters().get("chat_id"));
    }
}
