package best.team.petprojectsquad.handler.callbackQuery;

import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public class DogShelterInfoQuery implements InputHandlerQuery {
    @Override
    public List<BaseRequest> handle(long chatId) {
        return null;
    }

    @Override
    public BotState getHandlerName() {
        return null;
    }
}
