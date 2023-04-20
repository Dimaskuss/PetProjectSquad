package best.team.petprojectsquad.service.queryHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressDogQueryServiceTest {

    private AddressDogQueryService addressDogQueryService = new AddressDogQueryService();
    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage0 = new SendMessage(id, "Адрес: г. Первый, ул. Соседняя дом 15.");
        SendMessage sendMessage1 = new SendMessage(id, "Рабочие часы приюта для собак:\nПонедельник - Пятница: 10:00 - 17:00\nСуббота - Воскресенье: 12:00 - 16:00\nCхема проезда:");
        SendPhoto sendPhoto = new SendPhoto(id, new File("pictures/addressDog.png"));
        expectedArrayList.add(sendMessage0);
        expectedArrayList.add(sendMessage1);
        expectedArrayList.add(sendPhoto);


        List<BaseRequest> actualList = addressDogQueryService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(1).getClass(), expectedArrayList.get(1).getClass());
        assertEquals(actualList.get(2).getClass(), expectedArrayList.get(2).getClass());

        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(1).getParameters().get("chat_id"),expectedArrayList.get(1).getParameters().get("chat_id"));
        assertEquals(actualList.get(2).getParameters().get("chat_id"),expectedArrayList.get(2).getParameters().get("chat_id"));

    }


}