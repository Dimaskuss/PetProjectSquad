package best.team.petprojectsquad.handler.callbackQuery;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.SecurityContactService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class SecurityContact implements InputHandlerQuery {
    private final SecurityContactService securityContactService;
    @Override
    public List<BaseRequest> handle(long chatId) {
        return securityContactService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SECURITY_CONTACT;
    }
}
