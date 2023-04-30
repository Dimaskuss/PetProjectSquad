package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VolunteerQueryService implements QueryHandlerService {
    private final UserDataCache userDataCache;
    //:TODO Добавить также запись в колонку ( с какого приюта пришел пользователь )
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        userDataCache.setUsersCurrentBotState(id, BotState.GET_VOLUNTEER_REPLY);

        return requestArrayList;
    }
}
