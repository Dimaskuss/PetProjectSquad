package best.team.petprojectsquad.service.queryHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SafetyDogQueryServiceTest {

    private SafetyDogQueryService service = new SafetyDogQueryService();
    long id = 1005223990L;

    @Test
    void getReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "На территории приюта для собак, просим следовать правилам, которые могут помочь обеспечить безопасность животных и посетителей:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Запрет на кормление животных, запрет на использование вспышек фотоаппаратов, а также доступ в служебные помещения.");
        SendMessage sendMessage2 = new SendMessage(id, "2. Не приближайтесь к собакам без разрешения: пожалуйста, не приближайтесь к собакам, не выставляйте руки и не пытайтесь их погладить, не разрешив этого сотрудникам приюта. Некоторые животные могут быть напуганы посторонними людьми и реагировать агрессивно.");
        SendMessage sendMessage3 = new SendMessage(id, "3. Соблюдайте личную гигиену: перед посещением приюта убедитесь, что вы чисты, вам не следует посещать приют, если вы болеете.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Если вы не уверены, как вести себя с животными в приюте, спросите у персонала. Они могут дать вам инструкции, которые помогут вам избежать конфликта с животными и обеспечить вашу безопасность.");

        expectedArrayList.add(sendMessage0);
        expectedArrayList.add(sendMessage1);
        expectedArrayList.add(sendMessage2);
        expectedArrayList.add(sendMessage3);
        expectedArrayList.add(sendMessage4);

        List<BaseRequest> actualList = service.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(1).getClass(), expectedArrayList.get(1).getClass());
        assertEquals(actualList.get(2).getClass(), expectedArrayList.get(2).getClass());
        assertEquals(actualList.get(3).getClass(), expectedArrayList.get(3).getClass());
        assertEquals(actualList.get(4).getClass(), expectedArrayList.get(4).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(1).getParameters().get("chat_id"),expectedArrayList.get(1).getParameters().get("chat_id"));
        assertEquals(actualList.get(2).getParameters().get("chat_id"),expectedArrayList.get(2).getParameters().get("chat_id"));
        assertEquals(actualList.get(3).getParameters().get("chat_id"),expectedArrayList.get(3).getParameters().get("chat_id"));
        assertEquals(actualList.get(4).getParameters().get("chat_id"),expectedArrayList.get(4).getParameters().get("chat_id"));

    }
}