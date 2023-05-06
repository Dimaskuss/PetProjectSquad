package best.team.petprojectsquad.service.queryHandlerImpl.DogReportMenuService;

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
public class ReportMenuDogService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Выберите интересующий пункт меню:");
        Keyboard keyboard = getMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }

    /**
     * Метод формирует электронную клавиатуру на экране пользователя
     * @return клавиатура на экране пользователя
     */
    private Keyboard getMenuKeyboard() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Форма ежедневного отчета.").callbackData("/formReport")},
                        {new InlineKeyboardButton("Отправить отчет о питомце.").callbackData("/dogReport")},
                });
        return inlineKeyboard;
    }
}
