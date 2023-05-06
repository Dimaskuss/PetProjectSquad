package best.team.petprojectsquad.handler.callbackQueryImpl.CatReportMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatReportMenuService.ReportMenuCatService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReportCatMenu implements InputHandlerQuery {

    private final ReportMenuCatService reportCatMenuService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return reportCatMenuService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_REPORT_MENU;
    }
}
