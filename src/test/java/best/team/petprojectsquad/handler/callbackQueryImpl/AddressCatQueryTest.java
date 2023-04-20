package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandlerImpl.AddressCatQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressCatQueryTest {

    @Mock
    AddressCatQueryService service;

    @InjectMocks
    private AddressCatQuery catQuery;

    long id = 1005223990L;

    @Test
    void shouldReturnMessageHandle() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage0 = new SendMessage(id, "Адрес: г. Первый, ул. Средняя дом 8.");
        expectedArrayList.add(sendMessage0);

        when(service.getReplyMessage(id)).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = catQuery.handle(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));
    }

    private BotState botState = BotState.CAT_SHELTER_ADDRESS;

    @Test
    void shouldReturnHandlerName() {

        assertEquals(catQuery.getHandlerName(), botState);

    }
}