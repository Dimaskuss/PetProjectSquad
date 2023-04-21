package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
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
class CallbackQueryServiceTest {

    @Mock
    private UserDataCache userDataCache;

    @InjectMocks
    private CallbackQueryService service;
    long id = 1005223990L;

    @Test
    void getReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Отправьте сообщением Ваш номер телефона для связи, в формате +79315556677");
        expectedArrayList.add(sendMessage);

        BotState expectedBotState = BotState.VALIDATE_PHONE;
        when(userDataCache.getUsersCurrentBotState(id)).thenReturn(BotState.VALIDATE_PHONE);
        List<BaseRequest> actualList = service.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(userDataCache.getUsersCurrentBotState(id), expectedBotState);

    }
}