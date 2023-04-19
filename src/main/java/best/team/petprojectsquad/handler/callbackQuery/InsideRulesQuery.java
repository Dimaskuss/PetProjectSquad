package best.team.petprojectsquad.handler.callbackQuery;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.InsideRulesService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class InsideRulesQuery implements InputHandlerQuery {
    private final InsideRulesService insideRulesService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return insideRulesService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.INSIDE_RULES;
    }
}
