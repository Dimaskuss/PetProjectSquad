package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.ReasonsWhyCantBringAnimalQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class ReasonsWhyCantBringAnimalQuery implements InputHandlerQuery {
    private final ReasonsWhyCantBringAnimalQueryService reasonsWhyCantBringAnimalQueryService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return reasonsWhyCantBringAnimalQueryService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.REASONS_WHY_CANT_BRING_AN_ANIMAL;
    }
}
