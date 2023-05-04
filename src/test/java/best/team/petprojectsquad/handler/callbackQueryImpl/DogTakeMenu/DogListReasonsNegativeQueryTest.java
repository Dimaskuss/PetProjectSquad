package best.team.petprojectsquad.handler.callbackQueryImpl.DogTakeMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.callbackQueryImpl.ReasonsWhyCantBringAnimalQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.ReasonsWhyCantBringAnimalQueryService;
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
class DogListReasonsNegativeQueryTest {

    @Mock
    private ReasonsWhyCantBringAnimalQueryService reasonsWhyCantBringAnimalQueryService;

    @InjectMocks
    private ReasonsWhyCantBringAnimalQuery reasonsWhyCantBringAnimalQuery;

    private final BotState botState = BotState.REASONS_WHY_CANT_BRING_AN_ANIMAL;
    long id = 1005223990L;

    @Test
    void shouldReturnMessageHandle() {
        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Это список список причин, почему могут отказать и не дать забрать собаку из приюта:
                        Причина 1,
                        Причина 2;
                """);
        expectedArrayList.add(sendMessage);

        when(reasonsWhyCantBringAnimalQueryService.getReplyMessage(id)).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = reasonsWhyCantBringAnimalQuery.handle(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));
        assertEquals(actualList.get(0).getParameters().get("text"), expectedArrayList.get(0).getParameters().get("text"));
    }

    @Test
    void shouldReturnHandlerName() {

        assertEquals(reasonsWhyCantBringAnimalQuery.getHandlerName(), botState);

    }

}