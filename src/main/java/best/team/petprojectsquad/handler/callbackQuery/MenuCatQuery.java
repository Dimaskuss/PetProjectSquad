package best.team.petprojectsquad.handler.callbackQuery;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.MenuCatQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MenuCatQuery implements InputHandlerQuery {

    private final MenuCatQueryService menuCatQueryService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return menuCatQueryService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_SHELTER_MENU;
    }
}