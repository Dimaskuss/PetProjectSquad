package best.team.petprojectsquad.handler.callbackQuery;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.CatShelterAddressService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class CatShelterAddressQuery implements InputHandlerQuery {
    private final CatShelterAddressService catShelterAddressService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return catShelterAddressService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_SHELTER_ADDRESS;
    }
}
