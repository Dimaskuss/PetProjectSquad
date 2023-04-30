package best.team.petprojectsquad.handler.callbackQueryImpl.DogTakeMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.callbackQueryImpl.DogTakeMenu.DogTakeInfoQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService.DogTakeInfoService;
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
class DogTakeInfoQueryTest {
    @Mock
    private DogTakeInfoService dogTakeInfoService;
    @InjectMocks
    private DogTakeInfoQuery dogTakeInfoQuery;

    private final BotState botState = BotState.DOG_TAKE_INFO;
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

        when(dogTakeInfoService.getReplyMessage(id)).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = dogTakeInfoQuery.handle(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(0).getParameters().get("text"), expectedArrayList.get(0).getParameters().get("text"));
    }

    @Test
    void shouldReturnHandlerName() {

        assertEquals(dogTakeInfoQuery.getHandlerName(), botState);

    }
}