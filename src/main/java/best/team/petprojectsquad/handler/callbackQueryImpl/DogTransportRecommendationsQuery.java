package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.QueryHandlerService;
import best.team.petprojectsquad.service.queryHandlerImpl.DogTransportRecommendationsService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class DogTransportRecommendationsQuery implements InputHandlerQuery {

    private final DogTransportRecommendationsService dogTransportRecommendationsService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return dogTransportRecommendationsService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_TRANSPORT_RECOMMENDATION;
    }

}
