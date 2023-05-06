package best.team.petprojectsquad.handler.callbackQueryImpl.DogInfoMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.callbackQueryImpl.DogInfoMenu.PassDogQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService.PassDogQueryService;
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
class PassDogQueryTest {

    @Mock
    PassDogQueryService service;

    @InjectMocks
    private PassDogQuery dogQuery;

    long id = 1005223990L;
    private BotState botState = BotState.DOG_SHELTER_PASS;

    @Test
    void shouldReturnMessageHandle() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage0 = new SendMessage(id, "Test");
        expectedArrayList.add(sendMessage0);

        when(service.getReplyMessage(id)).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = dogQuery.handle(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));
    }

    @Test
    void shouldReturnHandlerName() {
        assertEquals(dogQuery.getHandlerName(), botState);
    }
}