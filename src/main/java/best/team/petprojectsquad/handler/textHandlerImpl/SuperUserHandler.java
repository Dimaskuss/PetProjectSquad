package best.team.petprojectsquad.handler.textHandlerImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerMessage;
import best.team.petprojectsquad.service.textHandlerImpl.SuperUserService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SuperUserHandler implements InputHandlerMessage {

    private final SuperUserService superUserService;

    @Override
    public List<BaseRequest> handle(Message inputMessage) {
        return superUserService.getReplyMessage(inputMessage);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SUPER_USER_VOLUNTEER;
    }
}
