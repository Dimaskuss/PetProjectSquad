package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.*;
import best.team.petprojectsquad.service.TextHandlerService;
import best.team.petprojectsquad.service.ValidatePhone;
import best.team.petprojectsquad.service.controllerServiceImpl.UserFeedBackControllerServiceImpl;
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
public class DogValidatePhoneService implements TextHandlerService, ValidatePhone {

    private final UserDataCache userDataCache;
    private final UserFeedBackControllerServiceImpl userFeedBackService;

    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        if (checkPhone(message.text())) {
                userFeedBackService.save(new UserFeedBack(
                        message.text(),
                        message.chat().id(),
                        message.chat().firstName()
                ));
                SendMessage sendMessage = new SendMessage(message.chat().id(), "Волонтер в ближайшее время Вам перезвонит.");
                requestArrayList.add(sendMessage);
                userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.START);

        } else {
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Телефон написан некорректно, пришлите еще раз в формате +79315556677");
            requestArrayList.add(sendMessage);
        }
        return requestArrayList;
    }

}
