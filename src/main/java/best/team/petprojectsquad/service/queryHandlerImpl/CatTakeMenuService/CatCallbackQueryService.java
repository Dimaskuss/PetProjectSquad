package best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CatCallbackQueryService implements QueryHandlerService {

    private final UserDataCache userDataCache;

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage = new SendMessage(id, "Отправьте сообщением Ваш номер телефона для связи, в формате +79315556677");
        requestArrayList.add(sendMessage);

        userDataCache.setUsersCurrentBotState(id, BotState.CAT_VALIDATE_CALLBACK);

        return requestArrayList;
    }

}