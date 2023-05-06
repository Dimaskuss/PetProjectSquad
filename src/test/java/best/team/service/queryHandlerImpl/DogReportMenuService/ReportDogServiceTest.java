package best.team.service.queryHandlerImpl.DogReportMenuService;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.service.queryHandlerImpl.DogReportMenuService.ReportDogService;
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
@ExtendWith(MockitoExtension.class)
class ReportDogServiceTest {

    @Mock
    UserDataCache userDataCache;

    @InjectMocks
    private ReportDogService reportDogService;

    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Отправьте в сообщении фото с информацией о питомце:");
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = reportDogService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));


    }
}