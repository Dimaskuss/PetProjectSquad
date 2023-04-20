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
public class InfoMenuCatQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Кошачий приют приветствует вас. Ниже вы можете получить всю информацию о приюте:");
        Keyboard keyboard = getMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }

    private Keyboard getMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Информация о приюте").callbackData("/catInfo")},
                        {new InlineKeyboardButton("Режим работы, адрес и схема проезда").callbackData("/catAddress")},
                        {new InlineKeyboardButton("Телефон охраны для оформления пропуска").callbackData("/catPass")},
                        {new InlineKeyboardButton("Рекомендации о технике безопасности").callbackData("/catSecurity")},
                        {new InlineKeyboardButton("Заказать обратный звонок").callbackData("/catCallback")},
                        {new InlineKeyboardButton("Связаться с волонтером").callbackData("/callVolunteer")}
                });

        return inlineKeyboard;
    }
}
