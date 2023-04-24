package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.HomeRecommendationsCatWithDisabilitiesService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class HomeRecommendationsCatWithDisabilitiesQuery implements InputHandlerQuery {

    private final HomeRecommendationsCatWithDisabilitiesService homeRecommendationsCatWithDisabilitiesService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return homeRecommendationsCatWithDisabilitiesService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.HOME_RECOMMENDATION_DIS_CAT;
    }
}
