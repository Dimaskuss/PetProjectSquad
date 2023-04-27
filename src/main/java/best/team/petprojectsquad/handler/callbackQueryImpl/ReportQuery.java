package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.ReportCatService;
import best.team.petprojectsquad.service.queryHandlerImpl.ReportService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReportQuery implements InputHandlerQuery {

    private final ReportService reportService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return reportService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.FORM_REPORT;
    }
}
