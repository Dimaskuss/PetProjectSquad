package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VolunteerQueryService implements QueryHandlerService {
    private UserRepository userRepository;
    private UserFeedBackRepository userFeedBackRepository;
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        if (!userFeedBackRepository.existsByChatId(id)) {
            User user = userRepository.getUserFeedBackByChatId(id);
            //TODO: придумать че с shelter type
            userFeedBackRepository.save(new UserFeedBack(id, "user.getName()"));
        }
        SendMessage sendMessage = new SendMessage(id, "Ваш запрос успешно зарегистрирован, ожидайте обратной связи!");
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }
}
