package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeInfoService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DogTakeInfoQuery implements InputHandlerQuery {

    private final DogTakeInfoService dogTakeInfoService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return dogTakeInfoService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_TAKE_INFO;
    }
}
