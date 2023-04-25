package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SuperUserServiceTest {
    private SuperUserService superUserService = new SuperUserService(new UserDataCache());

    private long id = 1005223990L;
    @Test
    void getReplyMessage() {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage = new SendMessage(id, "Введите пароль:");
        requestArrayList.add(sendMessage);
        List<BaseRequest> replyMessage = superUserService.getReplyMessage(id, "");
        assertEquals(replyMessage.size(), requestArrayList.size());
        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
    }
}