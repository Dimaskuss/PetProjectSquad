package best.team.petprojectsquad.service.queryHandler;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsideRulesServiceTest {
    InsideRulesService insideRulesService = new InsideRulesService();
    private static final Long ID = 1005223990L;
    @Test
    void getReplyMessage() {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(ID, """
                Правило 1
                Правило 2
                Правило 3
                """);
        requestArrayList.add(sendMessage);
        assertEquals(requestArrayList.get(0).getParameters(), insideRulesService.getReplyMessage(ID).get(0).getParameters());
    }
}