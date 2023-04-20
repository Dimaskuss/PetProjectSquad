package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatTransportRecommendationsService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class CatTransportRecommendationsQuery  implements InputHandlerQuery {

    private final CatTransportRecommendationsService catTransportRecommendationsService;


    @Override
    public List<BaseRequest> handle(long chatId) {
        return catTransportRecommendationsService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_TRANSPORT_RECOMMENDATION;
    }

}