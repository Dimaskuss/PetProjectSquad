package best.team.petprojectsquad.handler.callbackQueryImpl;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.HomeRecommendationsKittenService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class HomeRecommendationsKittenQuery implements InputHandlerQuery {

private final HomeRecommendationsKittenService homeRecommendationsKittenService;
    @Override
    public List<BaseRequest> handle(long chatId) {
        return homeRecommendationsKittenService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.HOME_RECOMMENDATION_KITTEN;
    }
}
