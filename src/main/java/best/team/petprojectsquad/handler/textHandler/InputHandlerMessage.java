package best.team.petprojectsquad.handler.textHandler;

import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface InputHandlerMessage {

    //интерфейс для всех обработчиков текстовых сообщений


    List<BaseRequest> handle(Message inputMessage);

    BotState getHandlerName();
}
