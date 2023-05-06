package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
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
public class SuperUserService implements TextHandlerService {
    private final UserDataCache userDataCache;
    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage = new SendMessage(message.chat().id(), "Введите пароль:");
        requestArrayList.add(sendMessage);

        userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.VALIDATE_VOLUNTEER);

        return requestArrayList;
    }

}
