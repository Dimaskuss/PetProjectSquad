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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@AllArgsConstructor
public class ValidatePhoneService implements TextHandlerService {
    private final UserDataCache userDataCache;
    private UserFeedBackRepository userFeedBackRepository;

    @Override
    public List<BaseRequest> getReplyMessage(long id, String message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        Pattern pattern = Pattern.compile("([А-я]+)\\s+(\\+7\\d{10})$");
        try {
            if (message != null) {
                Matcher matcher = pattern.matcher(message);
                if (matcher.find()) {
                    String name = matcher.group(1);
                    String phone_number = matcher.group(2);
                    if (!userFeedBackRepository.existsByChatId(id)) {
                        userFeedBackRepository.save(new UserFeedBack(phone_number, name, id, true));
                    }
                    SendMessage sendMessage = new SendMessage(id, "Волонтер в ближайшее время Вам перезвонит.");
                    requestArrayList.add(sendMessage);
                    userDataCache.setUsersCurrentBotState(id, BotState.START);
                } else {
                    SendMessage sendMessage = new SendMessage(id, "Данные заполнены некорректно, пришлите еще раз в формате \"Имя +79315556677\"");
                    requestArrayList.add(sendMessage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return requestArrayList;
    }

//    public boolean checkContact(String contact) {
////        todo: ОБЪЯСНИТЬ ПАТТЕРН ТЕЛЕФОНА
//        Pattern pattern = Pattern.compile("^([А-я])\\s+((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
//        Matcher matcher = pattern.matcher(contact);
//        String name = matcher.group(1);
//        String phone_number = matcher.group(2);
////        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}\\s+([А-я])$";
//        return contact.matches(pattern);
//    }
}
