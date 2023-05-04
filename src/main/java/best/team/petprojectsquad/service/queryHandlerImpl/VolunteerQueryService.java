package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.service.QueryHandlerService;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserFeedBackService;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserServiceImpl;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class VolunteerQueryService implements QueryHandlerService {

    private UserServiceImpl userRepositoryService;
    private UserFeedBackService userFeedBackRepositoryService;

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        if (!userFeedBackRepositoryService.existsByChatId(id)) {
            try {
                User user = userRepositoryService.findByChatId(id).orElseThrow(NullPointerException::new);
                userFeedBackRepositoryService.save(new UserFeedBack(id, user.getName()));
            }catch (NullPointerException e){
                log.error("Error in class VolunteerQueryService" + e.getMessage(), e);
            }
        }
        SendMessage sendMessage = new SendMessage(id, "Ваш запрос успешно зарегистрирован, ожидайте обратной связи!");
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }
}
