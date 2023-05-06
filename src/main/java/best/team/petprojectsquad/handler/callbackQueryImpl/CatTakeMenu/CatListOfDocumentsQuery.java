package best.team.petprojectsquad.handler.callbackQueryImpl.CatTakeMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService.CatListOfDocumentsService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CatListOfDocumentsQuery implements InputHandlerQuery {

    private final CatListOfDocumentsService service;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return service.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_TAKE_DOCUMENTS;
    }
}
