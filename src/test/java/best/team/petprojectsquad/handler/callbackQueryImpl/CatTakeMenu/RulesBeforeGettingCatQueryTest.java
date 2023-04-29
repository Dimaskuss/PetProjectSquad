package best.team.petprojectsquad.handler.callbackQueryImpl.CatTakeMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.callbackQueryImpl.CatTakeMenu.RulesBeforeGettingCatQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService.RulesBeforeGettingCatService;
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
class RulesBeforeGettingCatQueryTest {

    @Mock
    RulesBeforeGettingCatService service;

    @InjectMocks
    private RulesBeforeGettingCatQuery catQuery;

    long id = 1005223990L;
    private BotState botState = BotState.RULES_TAKE_CAT;

    @Test
    void shouldReturnMessageHandle() {
        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage0 = new SendMessage(id, "Test");
        expectedArrayList.add(sendMessage0);

        when(service.getReplyMessage(id)).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = catQuery.handle(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
    }

    @Test
    void shouldReturnHandlerName() {

        assertEquals(catQuery.getHandlerName(), botState);

    }
}