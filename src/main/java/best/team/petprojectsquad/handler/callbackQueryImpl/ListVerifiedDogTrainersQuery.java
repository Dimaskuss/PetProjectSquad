package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.ListVerifiedDogTrainersService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class ListVerifiedDogTrainersQuery implements InputHandlerQuery {

    private final ListVerifiedDogTrainersService listVerifiedDogTrainersService;
    @Override
    public List<BaseRequest> handle(long chatId) {
        return listVerifiedDogTrainersService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.VERIFIED_TRAINERS;
    }
}
