package best.team.petprojectsquad.handler.callbackQuery;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.MenuDogQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class MenuDodQuery implements InputHandlerQuery{

    private final MenuDogQueryService menuDogQueryService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return menuDogQueryService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_SHELTER_MENU;
    }
}
