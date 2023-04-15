package best.team.petprojectsquad.handler.callbackQuery;

import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface InputHandlerQuery {

    //интерфейс для всех обработчиков кнопок

    List<BaseRequest> handle(long chatId);

    BotState getHandlerName();
}
