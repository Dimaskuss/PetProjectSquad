package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class ValidatePhoneService implements TextHandlerService {

    private final UserDataCache userDataCache;
    private UserFeedBackRepository userFeedBackRepository;

    @Override
    public List<BaseRequest> getReplyMessage(long id, String message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        if (checkPhone(message)) {
            if (!userFeedBackRepository.existsByChatId(id)) {
                userFeedBackRepository.save(new UserFeedBack(message, id, true));
            }
            // TODO: 21.04.2023 надо сохранить телефон у юзера и сделать пометку для обратной связи (например boolean) - done
            SendMessage sendMessage = new SendMessage(id, "Волонтер в ближайшее время Вам перезвонит.");
            requestArrayList.add(sendMessage);
            userDataCache.setUsersCurrentBotState(id,BotState.START);

        } else {
            SendMessage sendMessage = new SendMessage(id, "Телефон написан не корректно, пришлите еще раз в формате +79315556677");
            requestArrayList.add(sendMessage);

        }

        return requestArrayList;
    }

    public boolean checkPhone(String phone) {
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        return phone.matches(regex);
    }
}
