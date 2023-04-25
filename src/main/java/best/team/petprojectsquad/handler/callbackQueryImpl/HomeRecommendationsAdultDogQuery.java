package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.HomeRecommendationsAdultDogService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class HomeRecommendationsAdultDogQuery implements InputHandlerQuery {

    private final HomeRecommendationsAdultDogService homeRecommendationsAdultDogService;
    @Override
    public List<BaseRequest> handle(long chatId) {
        return homeRecommendationsAdultDogService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.HOME_RECOMMENDATION_ADULT_DOG;
    }

}
