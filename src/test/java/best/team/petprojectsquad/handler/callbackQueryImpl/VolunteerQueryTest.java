package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.service.queryHandlerImpl.VolunteerQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class )
class VolunteerQueryTest {

    @Mock
    VolunteerQueryService service;

    @InjectMocks
    VolunteerQuery volunteerQuery;

    long id = 1005223990L;
    @Test
    void shouldReturnRightHandle() {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Ваш запрос успешно зарегистрирован, ожидайте обратной связи!");
        requestArrayList.add(sendMessage);

        when(service.getReplyMessage(id)).thenReturn(requestArrayList);

        List<BaseRequest> actualList = volunteerQuery.handle(id);

        assertEquals(actualList.size(), requestArrayList.size());
        assertEquals(actualList.get(0).getClass(), requestArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"), requestArrayList.get(0).getParameters().get("chat_id"));
    }

    @Test
    void getHandlerName() {
        assertEquals(volunteerQuery.getHandlerName(), BotState.CALL_VOLUNTEER);
    }
}