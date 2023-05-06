package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.ReportServiceForAll;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReportQueryForAll implements InputHandlerQuery {

    private final ReportServiceForAll reportService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return reportService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.FORM_REPORT;
    }
}
