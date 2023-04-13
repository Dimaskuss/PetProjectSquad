package best.team.petprojectsquad.handler.textHandler;

import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;

public interface InputHandlerMessage {

    SendMessage handle(Message inputMessage);

    BotState getHandlerName();
}
