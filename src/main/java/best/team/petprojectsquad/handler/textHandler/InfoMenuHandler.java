package best.team.petprojectsquad.handler.textHandler;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.InfoHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class InfoMenuHandler implements InputHandlerMessage {

    private final InfoHandlerService infoHandlerService;

    @Override
    public SendMessage handle(Message inputMessage) {
        return infoHandlerService.getReplyMessage(inputMessage.chat().id(), inputMessage.text());
    }

    @Override
    public BotState getHandlerName() {
        return BotState.INFO;
    }
}
