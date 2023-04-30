package best.team.petprojectsquad.handler.callbackQueryImpl.DogInfoMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService.PassDogQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PassDogQuery implements InputHandlerQuery {

    private final PassDogQueryService passDogQueryService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return passDogQueryService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_SHELTER_PASS;
    }
}
