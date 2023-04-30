package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService.DogListReasonsNegativeService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DogListReasonsNegativeServiceTest {
    private final DogListReasonsNegativeService dogListReasonsNegativeService = new DogListReasonsNegativeService();
    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Это список список причин, почему могут отказать и не дать забрать собаку из приюта:
                        Причина 1,
                        Причина 2;
                """);
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = dogListReasonsNegativeService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), expectedArrayList.get(0).getParameters().get("chat_id"));

    }

}