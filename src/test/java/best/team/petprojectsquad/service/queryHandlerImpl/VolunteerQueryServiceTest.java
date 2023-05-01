package best.team.petprojectsquad.service.queryHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VolunteerQueryServiceTest {
    @Autowired
    VolunteerQueryService service;
    private long id = 123;
    @Test
    void getReplyMessage() {
        List<BaseRequest> replyMessage = service.getReplyMessage(id);
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage = new SendMessage(id, "Ваш запрос успешно зарегистрирован, ожидайте обратной связи!");
        requestArrayList.add(sendMessage);

        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
    }
}