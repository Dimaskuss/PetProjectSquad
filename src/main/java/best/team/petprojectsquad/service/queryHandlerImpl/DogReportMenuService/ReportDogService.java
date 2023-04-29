package best.team.petprojectsquad.service.queryHandlerImpl.DogReportMenuService;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportDogService implements QueryHandlerService {

    private final UserDataCache userDataCache;

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Отправьте в сообщении фото с информацией о питомце:");
        requestArrayList.add(sendMessage);
        userDataCache.setUsersCurrentBotState(id, BotState.DOG_REPORT_VALIDATE);
        return requestArrayList;
    }

}
