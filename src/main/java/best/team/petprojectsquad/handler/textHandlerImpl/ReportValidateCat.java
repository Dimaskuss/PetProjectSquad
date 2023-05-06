package best.team.petprojectsquad.handler.textHandlerImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerMessage;
import best.team.petprojectsquad.service.textHandlerImpl.ReportValidateCatService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReportValidateCat implements InputHandlerMessage {

    private final ReportValidateCatService reportValidateCatService;

    @Override
    public List<BaseRequest> handle(Message inputMessage) {
        return reportValidateCatService.getReplyMessage(inputMessage);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_REPORT_VALIDATE;
    }
}
