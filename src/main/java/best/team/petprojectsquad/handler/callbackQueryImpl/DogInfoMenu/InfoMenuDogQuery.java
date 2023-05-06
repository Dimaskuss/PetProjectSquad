package best.team.petprojectsquad.handler.callbackQueryImpl.DogInfoMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService.InfoMenuDogQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class InfoMenuDogQuery implements InputHandlerQuery {

    private final InfoMenuDogQueryService infoDogQueryService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return infoDogQueryService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_INFO_MENU;
    }
}
