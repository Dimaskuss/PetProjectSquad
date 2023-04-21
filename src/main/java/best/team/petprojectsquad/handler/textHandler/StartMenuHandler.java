package best.team.petprojectsquad.handler.textHandler;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.textHandler.StartHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class StartMenuHandler implements InputHandlerMessage {

    private final StartHandlerService startHandlerService;

    @Override
    public List<BaseRequest> handle(Message inputMessage) {
        return startHandlerService.getReplyMessage(inputMessage.chat().id(), inputMessage.text());
    }

    @Override
    public BotState getHandlerName() {
        return BotState.START;
    }
}