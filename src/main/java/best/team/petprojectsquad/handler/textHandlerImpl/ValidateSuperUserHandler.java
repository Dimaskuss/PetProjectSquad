package best.team.petprojectsquad.handler.textHandlerImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerMessage;
import best.team.petprojectsquad.service.textHandlerImpl.ValidateSuperUserService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ValidateSuperUserHandler implements InputHandlerMessage {
    private final ValidateSuperUserService validateSuperUserService;

    @Override
    public List<BaseRequest> handle(Message inputMessage) {
        return validateSuperUserService.getReplyMessage(inputMessage);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.VALIDATE_VOLUNTEER;
    }

}
