package best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InfoMenuDogQueryServiceTest {

    private InfoMenuDogQueryService infoDogQueryService = new InfoMenuDogQueryService();
    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Собачий приют приветствует вас. Ниже вы можете получить всю информацию о приюте:");
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = infoDogQueryService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));


    }
}