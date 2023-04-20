package best.team.petprojectsquad.service.textHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StartHandlerServiceTest {

    private StartHandlerService startHandlerService = new StartHandlerService();
    long id = 1005223990L;
    String text = "/start";


    @Test
    void shouldReturnReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();

        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/mainMenu.png"));
        sendPhoto.caption("Вас приветствует приют для домашних животных.\n" +
                "Наш приют содержит бездомных, покалеченных и больных животных (без учёта постоянно прибывающих) и очень нуждается в помощи и благотворительности на постоянной основе. Будем признательны за каждый вклад.\n" +
                "Если вы неравнодушны, приезжайте общаться с хвостиками, привезите им вкусняшки, помогите копейкой, им же немного нужно для счастья. А самое большое счастье для четвероногого друга - обрести свой родной дом или чью-то родную душу.\n" +
                "Мы очень будем рады любой помощи.");
        SendMessage sendMessage = new SendMessage(id, "Выберите интересующий Вас приют:");

        expectedArrayList.add(sendPhoto);
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = startHandlerService.getReplyMessage(id, text);

        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(1).getClass(), expectedArrayList.get(1).getClass());

        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(1).getParameters().get("chat_id"), expectedArrayList.get(1).getParameters().get("chat_id"));


    }
}