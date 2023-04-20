package best.team.petprojectsquad.service.queryHandler;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdmissionRulesServiceTest {

    private AdmissionRulesService admissionRulesService = new AdmissionRulesService();

    private static final Long ID = 1005223990L;

    @Test
    void shouldReturnMessage() {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(ID, """
                Правило 1
                Правило 2
                Правило 3
                """);
        requestArrayList.add(sendMessage);
        List<BaseRequest> replyMessage = admissionRulesService.getReplyMessage(ID);

        assertEquals(requestArrayList.get(0).getParameters(), admissionRulesService.getReplyMessage(ID).get(0).getParameters());
    }
}