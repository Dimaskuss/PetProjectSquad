package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface InputHandlerQuery {

    List<BaseRequest> handle(long chatId);

    BotState getHandlerName();
}
