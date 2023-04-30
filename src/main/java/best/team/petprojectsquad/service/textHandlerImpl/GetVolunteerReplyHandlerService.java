package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GetVolunteerReplyHandlerService implements TextHandlerService {

    private final UserFeedBackRepository userFeedBackRepository;

    private final UserDataCache userDataCache;
    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        userFeedBackRepository.save(new UserFeedBack(message.chat().id(), message.from().username()));
        userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.START);
        SendMessage sendMessage = new SendMessage(message.chat().id(), "Ваш запрос успешно обработан, волонтер вам напишет");
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }
}
