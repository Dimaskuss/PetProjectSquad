package best.team.petprojectsquad.handler.callbackQueryImpl.CatReportMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatReportMenuService.ReportCatService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReportCat implements InputHandlerQuery {

    private final ReportCatService reportCatService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return reportCatService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_REPORT;
    }
}
