package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.HomeRecommendationsDogWithDisabilitiesService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class HomeRecommendationsDogWithDisabilitiesQuery implements InputHandlerQuery {

    private final HomeRecommendationsDogWithDisabilitiesService homeRecommendationsDogWithDisabilitiesService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return homeRecommendationsDogWithDisabilitiesService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.HOME_RECOMMENDATION_DIS_DOG;
    }
}
