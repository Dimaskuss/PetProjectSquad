package best.team.petprojectsquad.service.queryHandler;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkScheduleServiceTest {
    WorkScheduleService workScheduleService = new WorkScheduleService();
    private static final Long ID = 1005223990L;
    @Test
    void getReplyMessage() {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(ID, """
                ПН-ПТ: 10 - 18;
                СБ-ВС: 12 - 18;
                """);
        requestArrayList.add(sendMessage);
        assertEquals(requestArrayList.get(0).getParameters(), workScheduleService.getReplyMessage(ID).get(0).getParameters());
    }
}