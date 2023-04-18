package best.team.petprojectsquad;

import best.team.petprojectsquad.service.textHandler.InfoHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.hibernate.Remove;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InfoHandlerServiceTest {
    @Mock
    private InfoHandlerService infoHandlerServiceTestMock;

    @Test
    void shouldReturnReplyMessage() {
        Long id = 1005223990L;
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img_1.png"));
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);
        when(infoHandlerServiceTestMock.getReplyMessage(1005223990L, "/start")).thenReturn(requestArrayList);
        assertEquals(infoHandlerServiceTestMock.getReplyMessage(1005223990L, "/start"), requestArrayList);
    }
}
