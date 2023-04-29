package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.callbackQueryImpl.DogTakeMenu.TipsDogTrainerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService.TipsDogTrainerService;
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
class TipsDogTrainerQueryTest {

    @Mock
    private TipsDogTrainerService tipsDogTrainerService;

    @InjectMocks
    private TipsDogTrainerQuery tipsDogTrainerQuery;

    private final BotState botState = BotState.DOG_TIPS_TRAINER;
    long id = 1005223990L;

    @Test
    void shouldReturnMessageHandle() {
//        todo: проверить тестовое сообщение, почему в сообщении кошачий приют, но тест все равно проходит
        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Кошачий приют приветствует вас. Ниже представлена информация, которая поможет Вам разобраться
                с бюрократическими (оформление договора)
                и бытовыми (как подготовиться к жизни с животным) вопросами:
                """);
        expectedArrayList.add(sendMessage);

        when(tipsDogTrainerService.getReplyMessage(id)).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = tipsDogTrainerQuery.handle(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(0).getParameters().get("text"), expectedArrayList.get(0).getParameters().get("text"));
    }

    @Test
    void shouldReturnHandlerName() {

        assertEquals(tipsDogTrainerQuery.getHandlerName(), botState);

    }

}