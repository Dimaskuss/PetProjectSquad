package best.team.petprojectsquad.handler.callbackQueryImpl.CatInfoMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatInfoMenuService.InfoMenuCatQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class InfoMenuCatQuery implements InputHandlerQuery {

    private final InfoMenuCatQueryService infoCatQueryService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return infoCatQueryService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_INFO_MENU;
    }
}
