package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService.CatCallbackQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class VolunteerQueryServiceTest {
    @MockBean
    private UserDataCache userDataCache;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private VolunteerQueryService volunteerQueryService;
    long id = 1005223991L;

    @Test
    void getReplyMessage() {
        User user = new User(id, "name");
        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Ваш запрос успешно зарегистрирован, ожидайте обратной связи!");
        expectedArrayList.add(sendMessage);
        when(userDataCache.getUsersCurrentBotState(id)).thenReturn(BotState.GET_VOLUNTEER_REPLY);
        when(userRepository.findByChatId(id)).thenReturn(Optional.of(user));

        List<BaseRequest> actualList = volunteerQueryService.getReplyMessage(id);

        assertEquals(expectedArrayList.get(0).getParameters(), actualList.get(0).getParameters());
    }
}