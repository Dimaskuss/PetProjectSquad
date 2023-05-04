package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.service.TextHandlerService;
import best.team.petprojectsquad.service.ValidatePhone;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserCatServiceImpl;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserServiceImpl;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CatValidatePhoneService implements TextHandlerService, ValidatePhone {

    private final UserDataCache userDataCache;
    private final UserServiceImpl userService;
    private final UserCatServiceImpl userCatService;

    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        if (checkPhone(message.text())) {
            try {
            User user = userService.findByChatId(message.chat().id()).orElseThrow(NullPointerException::new);
            UserCat userCat = userCatService.getByUser(user).orElse(new UserCat(user));
            userCat.setUserNeedHelp(true);
            userCat.setPhoneNumber(message.text());
            userCat.setChatId(message.chat().id());
            userCatService.save(userCat);
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Волонтер в ближайшее время Вам перезвонит.");
            requestArrayList.add(sendMessage);
            userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.START);
            } catch (Exception e) {
                log.error("Error in class CatValidatePhoneService:" + e.getMessage(), e);
            }
        } else {
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Телефон написан некорректно, пришлите еще раз в формате +79315556677");
            requestArrayList.add(sendMessage);

        }

        return requestArrayList;
    }


}
