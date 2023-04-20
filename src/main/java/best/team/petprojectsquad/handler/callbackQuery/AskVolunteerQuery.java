package best.team.petprojectsquad.handler.callbackQuery;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.AskVolunteerService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class AskVolunteerQuery implements InputHandlerQuery {
    private final AskVolunteerService askVolunteerService;
    @Override
    public List<BaseRequest> handle(long chatId) {
        return askVolunteerService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.ASK_VOLUNTEER;
    }
}
