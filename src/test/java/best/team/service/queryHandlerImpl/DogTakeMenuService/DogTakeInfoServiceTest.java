package best.team.service.queryHandlerImpl.DogTakeMenuService;

import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService.DogTakeInfoService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DogTakeInfoServiceTest {

    private final DogTakeInfoService dogTakeInfoService = new DogTakeInfoService();
    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Собачий приют приветствует вас. Ниже представлена информация, которая поможет Вам разобраться
                с бюрократическими (оформление договора)
                и бытовыми (как подготовиться к жизни с животным) вопросами:
                """);
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = dogTakeInfoService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));

    }
}