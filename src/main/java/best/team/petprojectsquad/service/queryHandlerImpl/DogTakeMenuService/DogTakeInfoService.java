package best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogTakeInfoService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Собачий приют приветствует вас. Ниже представлена информация, которая поможет Вам разобраться
                с бюрократическими (оформление договора)
                и бытовыми (как подготовиться к жизни с животным) вопросами:
                """);
        Keyboard keyboard = getTakeInfoCatMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }

    private Keyboard getTakeInfoCatMenuKeyboard() {

        return new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Правила знакомства с будущим питомцем").
                                callbackData("/rulesBeforeGettingDog")},
                        {new InlineKeyboardButton("Список документов, чтобы взять питомца из приюта").
                                callbackData("/dogListOfDocuments")},
                        {new InlineKeyboardButton("Рекомендации по транспортировке питомца").
                                callbackData("/dogTransportRecommendations")},
                        {new InlineKeyboardButton("Обустройство дома для щенка").
                                callbackData("/homeRecommendationsPuppy")},
                        {new InlineKeyboardButton("Обустройство дома для взрослой собаки").
                                callbackData("/homeRecommendationsAdultDog")},
                        {new InlineKeyboardButton("Обустройство дома для для питомца с ОВЗ").
                                callbackData("/homeRecommendationsDogWithDisabilities")},
                        {new InlineKeyboardButton("Советы кинолога по первичному общению с собакой").
                                callbackData("/tipsDogTrainer")},
                        {new InlineKeyboardButton("Рекомендации по проверенным кинологам").
                                callbackData("/listVerifiedDogTrainers")},
                        {new InlineKeyboardButton("Почему могут отказать и не дать забрать питомца").
                                callbackData("/reasonsWhy")},
                        {new InlineKeyboardButton("Отправить контактные данные для связи").
                                callbackData("/dogCallback")},
                        {new InlineKeyboardButton("Связаться с волонтером").
                                callbackData("/callVolunteer")}
                });
    }
}
