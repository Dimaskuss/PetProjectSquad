package best.team.petprojectsquad.handler.callbackQuery;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.WorkScheduleService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class WorkScheduleQuery implements InputHandlerQuery {
    private final WorkScheduleService workScheduleService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return workScheduleService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.WORK_SCHEDULE;
    }
}
