package best.team.service.queryHandlerImpl;

import best.team.petprojectsquad.service.queryHandlerImpl.MenuDogQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuDogQueryServiceTest {

    private MenuDogQueryService menuDogQueryService = new MenuDogQueryService();
    long id = 1005223990L;

    @Test
    void getReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, " Собачий приют рад приветствовать Вас:");
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = menuDogQueryService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));

    }
}