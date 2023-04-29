package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService.ListVerifiedDogTrainersService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListVerifiedDogTrainersServiceTest {

    private final ListVerifiedDogTrainersService listVerifiedDogTrainersService = new ListVerifiedDogTrainersService();
    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Собачий приют приветствует вас. Ниже представлены рекомендации по проверенным кинологам 
                для дальнейшего обращения к ним:
                Совет 1,
                Совет 2,
                Совет 3;
                """);
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = listVerifiedDogTrainersService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));

    }

}