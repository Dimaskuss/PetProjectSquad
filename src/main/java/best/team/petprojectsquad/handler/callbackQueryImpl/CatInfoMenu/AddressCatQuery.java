package best.team.petprojectsquad.handler.callbackQueryImpl.CatInfoMenu;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.InputHandlerQuery;
import best.team.petprojectsquad.service.queryHandlerImpl.CatInfoMenuService.AddressCatQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AddressCatQuery implements InputHandlerQuery {

    private final AddressCatQueryService catShelterAddressService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return catShelterAddressService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_SHELTER_ADDRESS;
    }
}
