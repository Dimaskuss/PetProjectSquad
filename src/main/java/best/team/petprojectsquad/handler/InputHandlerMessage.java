package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface InputHandlerMessage {

    //интерфейс для всех обработчиков текстовых сообщений

    /**
     * Обработка сообщения, полученного от пользователя
     *
     * @param inputMessage сообщение пользователя
     * @return ответ пользователю
     */
    List<BaseRequest> handle(Message inputMessage);

    BotState getHandlerName();
}
