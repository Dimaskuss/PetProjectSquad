package best.team.petprojectsquad.handler.callbackQueryImpl.CatTakeMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService.CatCallbackQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CatCallbackQuery implements InputHandlerQuery {

    private final CatCallbackQueryService catCallbackQueryService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return catCallbackQueryService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_SHELTER_CALLBACK;
    }
}
