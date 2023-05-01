package best.team.petprojectsquad.handler.textHandlerImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerMessage;
import best.team.petprojectsquad.service.textHandlerImpl.DogValidatePhoneService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class DogValidatePhoneHandler implements InputHandlerMessage {

    private final DogValidatePhoneService dogValidatePhoneService;

    @Override
    public List<BaseRequest> handle(Message inputMessage) {
        return dogValidatePhoneService.getReplyMessage(inputMessage);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_VALIDATE_CALLBACK;
    }
}
