package best.team.petprojectsquad.handler.callbackQuery;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.service.queryHandler.DogShelterAddressService;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class DogShelterAddressQuery implements InputHandlerQuery {
    private final DogShelterAddressService dogShelterAddressService;

    @Override
    public List<BaseRequest> handle(long chatId) {
        return dogShelterAddressService.getReplyMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_SHELTER_ADDRESS;
    }
}
