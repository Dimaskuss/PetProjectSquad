package best.team.petprojectsquad.service.queryHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RulesBeforeGettingCatServiceTest {

    private RulesBeforeGettingCatService service = new RulesBeforeGettingCatService();
    long id = 1005223990L;

    @Test
    void getReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "Перед забиранием кошки из приюта, важно убедиться, что вы готовы к ответственности за нового питомца. Также необходимо знать, как правильно знакомиться с кошкой, " +
                "чтобы установить с ней контакт и сделать переезд в новый дом более комфортным.\nВот несколько правил знакомства с кошкой:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Не беспокойте кошку: Кошки могут быть очень скрытными и пугливыми");
        SendMessage sendMessage2 = new SendMessage(id, "2. Подходите к кошке сбоку: Подойдите к кошке сбоку, чтобы она могла увидеть вас и понюхать вас.");
        SendMessage sendMessage3 = new SendMessage(id, "3. Говорите с кошкой мягким и спокойным голосом.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Игрушки могут помочь в установлении контакта с кошкой.");

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