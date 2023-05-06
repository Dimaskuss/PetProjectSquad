package best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService;

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
public class CatTakeInfoService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Кошачий приют приветствует вас. Ниже представлена информация, которая поможет Вам разобраться
                с бюрократическими (оформление договора)
                и бытовыми (как подготовиться к жизни с животным) вопросами:
                """);
        Keyboard keyboard = getTakeInfoCatMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }

    /**
     * Метод формирует электронную клавиатуру на экране пользователя
     * @return клавиатура на экране пользователя
     */
    private Keyboard getTakeInfoCatMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Правила знакомства с будущим питомцем").
                                callbackData("/rulesBeforeGettingCat")},
                        {new InlineKeyboardButton("Список документов, чтобы взять питомца из приюта").
                                callbackData("/catListOfDocuments")},
                        {new InlineKeyboardButton("Рекомендации по транспортировке питомца").
                                callbackData("/catTransportRecommendations")},
                        {new InlineKeyboardButton("Обустройство дома для котенка").
                                callbackData("/homeRecommendationsKitten")},
                        {new InlineKeyboardButton("Обустройство дома для взрослой кошки").
                                callbackData("/homeRecommendationsAdultCat")},
                        {new InlineKeyboardButton("Обустройство дома для для питомца с ОВЗ").
                                callbackData("/homeRecommendationsCatWithDisabilities")},
                        {new InlineKeyboardButton("Почему могут отказать и не дать забрать питомца").
                                callbackData("/reasonsWhy")},
                        {new InlineKeyboardButton("Отправить контактные данные для связи").
                                callbackData("/catCallback")},
                        {new InlineKeyboardButton("Связаться с волонтером").callbackData("/callVolunteer")}
                });

        return inlineKeyboard;
    }
}
