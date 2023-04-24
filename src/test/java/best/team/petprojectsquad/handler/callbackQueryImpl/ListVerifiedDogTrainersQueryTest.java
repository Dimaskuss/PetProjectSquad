package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandlerImpl.ListVerifiedDogTrainersService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListVerifiedDogTrainersQueryTest {
    @Mock
    private ListVerifiedDogTrainersService listVerifiedDogTrainersService;

    @InjectMocks
    private ListVerifiedDogTrainersQuery listVerifiedDogTrainersQuery;

    private final BotState botState = BotState.VERIFIED_TRAINERS;
    long id = 1005223990L;

    @Test
    void shouldReturnMessageHandle() {
//        todo: проверить тестовое сообщение, почему в сообщении кошачий приют, но тест все равно проходит
        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Собачий приют приветствует вас. Ниже представлены рекомендации по проверенным кинологам 
                для дальнейшего обращения к ним:
                Совет 1,
                Совет 2,
                Совет 3;
                """);
        expectedArrayList.add(sendMessage);

        when(listVerifiedDogTrainersService.getReplyMessage(id)).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = listVerifiedDogTrainersQuery.handle(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(0).getParameters().get("text"), expectedArrayList.get(0).getParameters().get("text"));
    }

    @Test
    void shouldReturnHandlerName() {

        assertEquals(listVerifiedDogTrainersQuery.getHandlerName(), botState);

    }

}