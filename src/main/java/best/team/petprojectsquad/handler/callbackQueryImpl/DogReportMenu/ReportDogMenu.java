package best.team.petprojectsquad.handler.callbackQueryImpl.DogReportMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogReportMenuService.ReportMenuDogService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReportDogMenu implements InputHandlerQuery {

    private final ReportMenuDogService reportDogMenuService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return reportDogMenuService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_REPORT_MENU;
    }
}
