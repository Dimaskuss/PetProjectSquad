package best.team.petprojectsquad.handler.callbackQueryImpl.CatTakeMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService.RulesBeforeGettingCatService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RulesBeforeGettingCatQuery implements InputHandlerQuery {

    private final RulesBeforeGettingCatService rulesBeforeGettingCatService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return rulesBeforeGettingCatService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.RULES_TAKE_CAT;
    }
}
