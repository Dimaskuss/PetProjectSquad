package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface InputHandlerSendMessageQuery {
    List<BaseRequest> handle(Message message);

    BotState getHandlerName();
}
