package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.callbackQuery.InputHandlerQuery;
import best.team.petprojectsquad.handler.textHandler.InputHandlerMessage;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BotStateContext {

    private final Map<BotState, InputHandlerMessage> messageHandlers = new HashMap<>();

    private final Map<BotState, InputHandlerQuery> queryHandlers = new HashMap<>();


    public BotStateContext(List<InputHandlerMessage> messageHandlers, List<InputHandlerQuery> queryHandlers) {
        messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getHandlerName(), handler));
        queryHandlers.forEach(queryHandler -> this.queryHandlers.put(queryHandler.getHandlerName(), queryHandler));
    }

    public List<BaseRequest> processInputMessage(BotState currentState, Message message) {
        InputHandlerMessage currentMessageHandler = findMessageHandler(currentState);
        return currentMessageHandler.handle(message);
    }

    private InputHandlerMessage findMessageHandler(BotState currentState) {
        return messageHandlers.get(currentState);
    }

    public List<BaseRequest> processInputQuery(BotState currentState, long chatId) {
        InputHandlerQuery currentQueryHandler = findQueryHandler(currentState);
        return currentQueryHandler.handle(chatId);
    }

    private InputHandlerQuery findQueryHandler(BotState currentState) {
        return queryHandlers.get(currentState);
    }


}
