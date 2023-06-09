package best.team.service.textHandlerImpl;

import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.textHandlerImpl.StartHandlerService;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
class StartHandlerServiceTest {
    @Mock
    private StartHandlerService startHandlerService;
    long id = 10052239900L;
    String text = "/start";
    @Test
    void shouldReturnReplyMessage() throws URISyntaxException, IOException {

        List<BaseRequest> expectedArrayList = new ArrayList<>();

//        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/mainMenu.png"));
//        sendPhoto.caption("Вас приветствует приют для домашних животных.\n" +
//                "Наш приют содержит бездомных, покалеченных и больных животных (без учёта постоянно прибывающих) и очень нуждается в помощи и благотворительности на постоянной основе. Будем признательны за каждый вклад.\n" +
//                "Если вы неравнодушны, приезжайте общаться с хвостиками, привезите им вкусняшки, помогите копейкой, им же немного нужно для счастья. А самое большое счастье для четвероногого друга - обрести свой родной дом или чью-то родную душу.\n" +
//                "Мы очень будем рады любой помощи.");
        SendMessage sendMessage = new SendMessage(id, "Выберите интересующий Вас приют:");

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "/info"), Update.class);
//        expectedArrayList.add(sendPhoto);
        expectedArrayList.add(sendMessage);
        when(startHandlerService.getReplyMessage(update.message())).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = startHandlerService.getReplyMessage(update.message());

        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
//        assertEquals(actualList.get(1).getClass(), expectedArrayList.get(1).getClass());

        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
//        assertEquals(actualList.get(1).getParameters().get("chat_id"), expectedArrayList.get(1).getParameters().get("chat_id"));


    }
}