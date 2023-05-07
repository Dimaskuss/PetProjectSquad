package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserFeedBackService;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserServiceImpl;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VolunteerQueryServiceTest {
    @Mock
    private UserServiceImpl userRepositoryService;
    @Mock
    private UserFeedBackService userFeedBackRepositoryService;
    @InjectMocks
    private VolunteerQueryService volunteerQueryService;
    long id = 1005223991L;
    User user = new User(id, "name");

    @Test
    void getReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Ваш запрос успешно зарегистрирован, ожидайте обратной связи!");
        expectedArrayList.add(sendMessage);
        when(userRepositoryService.findByChatId(id)).thenReturn(Optional.of(user));
        when(userFeedBackRepositoryService.save(new UserFeedBack(id, user.getName()))).thenReturn(id);

        List<BaseRequest> actualList = volunteerQueryService.getReplyMessage(id);

        assertEquals(expectedArrayList.size(), actualList.size());
    }
}