package best.team.petprojectsquad.handler.callbackQueryImpl.DogTakeMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService.DogListOfDocumentsService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DogListOfDocumentsQuery implements InputHandlerQuery {

    private final DogListOfDocumentsService service;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return service.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_TAKE_DOCUMENTS;
    }
}
