package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.textHandler.InputHandlerMessage;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BotStateContext {


    private final Map<BotState, InputHandlerMessage> messageHandlers = new HashMap<>();



    public BotStateContext(List<InputHandlerMessage> messageHandlers) {
        messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getHandlerName(), handler));
    }


    public SendMessage processInputMessage(BotState currentState, Message message) {
        InputHandlerMessage currentMessageHandler = findMessageHandler(currentState);
        return currentMessageHandler.handle(message);
    }


    private InputHandlerMessage findMessageHandler(BotState currentState) {
        return messageHandlers.get(currentState);
    }



}
