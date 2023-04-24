package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.entity.SuperUserVolunteer;
import best.team.petprojectsquad.repository.SuperUserVolunteerRepository;
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
public class ValidateSuperUserService implements TextHandlerService {
    //Поле с паролем, возможно нужно вынести в другой класс
    // TODO:есть идея создать Entity password и к ней БД, чтобы была история паролей
    private static final String SUPER_USER_PASSWORD = "Volunteer12345";
    private final UserDataCache userDataCache;
    private SuperUserVolunteerRepository superUserVolunteerRepository;
    private final UserFeedBackRepository userFeedBackRepository;
    @Override
    public List<BaseRequest> getReplyMessage(long id, String password) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        if (checkPassword(password)) {
            if (!superUserVolunteerRepository.existsByChatId(id)) {
                superUserVolunteerRepository.save(new SuperUserVolunteer(id));
            }
            SendMessage sendMessage = new SendMessage(id, "Добро пожаловать!");
            SendMessage sendMessage1 = new SendMessage(id, "Ниже будет приведен список пользователей, которым нужна помощь");
            SendMessage sendMessage2 = new SendMessage(id, userFeedBackRepository.findAll().toString());
            requestArrayList.add(sendMessage);
            requestArrayList.add(sendMessage1);
            requestArrayList.add(sendMessage2);
            userDataCache.setUsersCurrentBotState(id,BotState.START);
            //возможно тут нужна userDataCahce
        } else {
            SendMessage sendMessage = new SendMessage(id, "Пароль введен некорректно");
            requestArrayList.add(sendMessage);

        }

        return requestArrayList;
    }

    public boolean checkPassword(String message) {
        return message.equals(SUPER_USER_PASSWORD);
    }
}
