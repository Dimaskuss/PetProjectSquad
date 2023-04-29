package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService.RulesBeforeGettingDogService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RulesBeforeGettingDogServiceTest {

    private RulesBeforeGettingDogService service = new RulesBeforeGettingDogService();
    long id = 1005223990L;

    @Test
    void getReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "Когда вы планируете забрать собаку из приюта, очень важно правильно знакомиться с ней и установить с ней контакт. Таким образом, собака будет чувствовать себя комфортно и безопасно," +
                " когда переедет к вам домой.\nВот несколько правил знакомства с собакой:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Подходите к собаке медленно и спокойно: Не подходите к собаке слишком быстро или слишком близко.");
        SendMessage sendMessage2 = new SendMessage(id, "2. Наклонение над собакой может быть воспринято ею как угроза.");
        SendMessage sendMessage3 = new SendMessage(id, "3. Говорите с собакой мягким и спокойным голосом.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Лакомства могут помочь в установлении контакта с собакой.");

        expectedArrayList.add(sendMessage0);
        expectedArrayList.add(sendMessage1);
        expectedArrayList.add(sendMessage2);
        expectedArrayList.add(sendMessage3);
        expectedArrayList.add(sendMessage4);

        List<BaseRequest> actualList = service.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));

    }
}