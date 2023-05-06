package best.team.petprojectsquad.service.queryHandlerImpl.CatReportMenuService;

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
public class ReportCatService implements QueryHandlerService {

    private final UserDataCache userDataCache;
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Отправьте в сообщении фото с информацией о питомце:");
        requestArrayList.add(sendMessage);
        userDataCache.setUsersCurrentBotState(id, BotState.CAT_REPORT_VALIDATE);
        return requestArrayList;
    }

}
