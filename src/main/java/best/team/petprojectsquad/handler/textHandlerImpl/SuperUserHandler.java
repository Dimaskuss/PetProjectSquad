package best.team.petprojectsquad.handler.textHandlerImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.textHandlerImpl.SuperUserService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SuperUserHandler implements InputHandlerQuery {
    private final SuperUserService superUserService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return superUserService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SUPER_USER_VOLUNTEER;
    }
}
