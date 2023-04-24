package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.PassCatQueryService;
import best.team.petprojectsquad.service.queryHandlerImpl.SafetyCatQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SafetyCatQuery implements InputHandlerQuery {

    private final SafetyCatQueryService safetyCatQueryService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return safetyCatQueryService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_SHELTER_SAFETY;
    }
}
