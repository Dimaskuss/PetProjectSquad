package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogListReasonsNegativeService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DogListReasonsNegativeQuery implements InputHandlerQuery {

    private final DogListReasonsNegativeService dogListReasonsNegativeService;
    @Override
    public List<BaseRequest> handle(long chatId) {
        return dogListReasonsNegativeService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_TAKE_NEGATIVE;
    }
}
