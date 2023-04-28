package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.entity.SuperUserVolunteer;
import best.team.petprojectsquad.repository.SuperUserVolunteerRepository;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidateSuperUserService implements TextHandlerService {
    //Поле с паролем, возможно нужно вынести в другой класс
    // TODO:есть идея создать Entity password и к ней БД, чтобы была история паролей
    @Value("${super.user.password}")
    private String password;

    public ValidateSuperUserService(UserDataCache userDataCache, SuperUserVolunteerRepository superUserVolunteerRepository, UserFeedBackRepository userFeedBackRepository) {
        this.userDataCache = userDataCache;
        this.superUserVolunteerRepository = superUserVolunteerRepository;
        this.userFeedBackRepository = userFeedBackRepository;
    }

    private final UserDataCache userDataCache;
    private final SuperUserVolunteerRepository superUserVolunteerRepository;
    private final UserFeedBackRepository userFeedBackRepository;
    @Override
    public List<BaseRequest> getReplyMessage(Message password) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        if (checkPassword(password.text())) {
            if (!superUserVolunteerRepository.existsByChatId(password.chat().id())) {
                superUserVolunteerRepository.save(new SuperUserVolunteer(password.chat().id()));
            }
            SendMessage sendMessage = new SendMessage(password.chat().id(), "Добро пожаловать!");
            SendMessage sendMessage1 = new SendMessage(password.chat().id(), "Ниже будет приведен список пользователей, которым нужна помощь");
            SendMessage sendMessage2 = new SendMessage(password.chat().id(), userFeedBackRepository.findAll().toString());
            requestArrayList.add(sendMessage);
            requestArrayList.add(sendMessage1);
            requestArrayList.add(sendMessage2);
            userDataCache.setUsersCurrentBotState(password.chat().id(),BotState.START);
        } else {
            SendMessage sendMessage = new SendMessage(password.chat().id(), "Пароль введен некорректно");
            requestArrayList.add(sendMessage);

        }

        return requestArrayList;
    }

    public boolean checkPassword(String message) {
        return message.equals(password);
    }
}
