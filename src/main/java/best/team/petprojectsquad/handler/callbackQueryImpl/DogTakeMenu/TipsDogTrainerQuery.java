package best.team.petprojectsquad.handler.callbackQueryImpl.DogTakeMenu;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService.TipsDogTrainerService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TipsDogTrainerQuery implements InputHandlerQuery {

    private TipsDogTrainerService tipsDogTrainerService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return tipsDogTrainerService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_TIPS_TRAINER;
    }
}
