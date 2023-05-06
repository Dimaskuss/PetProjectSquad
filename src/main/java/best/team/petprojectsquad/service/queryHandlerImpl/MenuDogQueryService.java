package best.team.petprojectsquad.service.queryHandlerImpl;

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
public class MenuDogQueryService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, " Собачий приют рад приветствовать Вас:");
        Keyboard keyboard = getMainMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }
    /**
     * Метод формирует электронную клавиатуру на экране пользователя
     * @return клавиатура на экране пользователя
     */
    private Keyboard getMainMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Узнать информацию о приюте").callbackData("/dogInfoMenu")},
                        {new InlineKeyboardButton("Как взять животное из приюта").callbackData("/dogTakeInfo")},
                        {new InlineKeyboardButton("Прислать отчет о питомце").callbackData("/dogReportMenu")},
                        {new InlineKeyboardButton("Связаться с волонтером").callbackData("/callVolunteer")},
                });

        return inlineKeyboard;
    }
}

