package best.team.petprojectsquad.handler.callbackQueryImpl;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatTakeInfoService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CatTakeInfoQuery implements InputHandlerQuery {

    private final CatTakeInfoService catTakeInfoService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return catTakeInfoService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_TAKE_INFO;
    }
}
