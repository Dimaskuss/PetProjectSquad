package best.team.petprojectsquad.handler.callbackQuery;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.AdmissionRulesService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AdmissionRulesQuery implements InputHandlerQuery {
    private final AdmissionRulesService admissionRulesService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return admissionRulesService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.ADMISSION_RULES;
    }
}
