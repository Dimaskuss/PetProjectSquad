package best.team.petprojectsquad.handler.telegramHandlerImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerSendMessageQuery;
import best.team.petprojectsquad.service.textHandlerImpl.TelegramBotHandlerSendMessageQueryService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TelegramBotHandlerSendMessageQuery implements InputHandlerSendMessageQuery {

    private final TelegramBotHandlerSendMessageQueryService telegramBotHandlerSendMessageQueryService;
    @Override
    public List<BaseRequest> handle(Message message) {
        return telegramBotHandlerSendMessageQueryService.getReplyMessage(message);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CALL_VOLUNTEER;
    }
}
