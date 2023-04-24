package best.team.petprojectsquad.service.textHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidatePhoneServiceTest {
    @Autowired
    private ValidatePhoneService validatePhoneService;

    private String message = "89356657658";
    private long id = 1005223990L;

    @Test
    void getReplyMessage() {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Волонтер в ближайшее время Вам перезвонит.");
        requestArrayList.add(sendMessage);
        List<BaseRequest> replyMessage = validatePhoneService.getReplyMessage(id, message);
        assertEquals(replyMessage.size(), requestArrayList.size());
        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
    }
}