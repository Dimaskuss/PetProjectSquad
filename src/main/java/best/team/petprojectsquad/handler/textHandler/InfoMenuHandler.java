package best.team.petprojectsquad.handler.textHandler;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.InfoHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class InfoMenuHandler implements InputHandlerMessage {

    private final InfoHandlerService infoHandlerService;

    //передаем обработку входящего сообщения в слой сервиса в класс -> InfoHandlerService
    //для удобства разделил inputMessage на (лонг номер чата, стринг сам текст)
    @Override
    public List<BaseRequest> handle(Message inputMessage) {
        return infoHandlerService.getReplyMessage(inputMessage.chat().id(), inputMessage.text());
    }

    @Override
    public BotState getHandlerName() {
        return BotState.INFO;
    }
}
