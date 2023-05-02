package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.*;
import best.team.petprojectsquad.service.TextHandlerService;
import best.team.petprojectsquad.service.ValidatePhone;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserDogServiceImpl;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserServiceImpl;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DogValidatePhoneService implements TextHandlerService, ValidatePhone {

    private final UserDataCache userDataCache;
    private final UserServiceImpl userService;
    private final UserDogServiceImpl userDogService;

    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        if (checkPhone(message.text())) {
            if (userDogService.getByUser(userService.get(message.chat().id()).get()).isEmpty()){
                UserDog userDog = new UserDog();
                userDog.setUserNeedHelp(true);
                userDog.setUser(userService.get(message.chat().id()).get());
                userDog.setPhoneNumber(message.text());
            }
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Волонтер в ближайшее время Вам перезвонит.");
            requestArrayList.add(sendMessage);
            userDataCache.setUsersCurrentBotState(message.chat().id(),BotState.START);
        } else {
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Телефон написан некорректно, пришлите еще раз в формате +79315556677");
            requestArrayList.add(sendMessage);
        }
        return requestArrayList;
    }

}
