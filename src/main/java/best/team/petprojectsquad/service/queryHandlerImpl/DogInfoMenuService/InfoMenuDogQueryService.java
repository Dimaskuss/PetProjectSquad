package best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService;

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
public class InfoMenuDogQueryService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Собачий приют приветствует вас. Ниже вы можете получить всю информацию о приюте:");
        Keyboard keyboard = getMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }

    private Keyboard getMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Пару слов о нашем приюте").callbackData("/dogInfo")},
                        {new InlineKeyboardButton("Режим работы, адрес и схема проезда").callbackData("/dogAddress")},
                        {new InlineKeyboardButton("Телефон охраны для оформления пропуска").callbackData("/dogPass")},
                        {new InlineKeyboardButton("Рекомендации о технике безопасности").callbackData("/dogSafety")},
                        {new InlineKeyboardButton("Заказать обратный звонок").callbackData("/dogCallback")},
                        {new InlineKeyboardButton("Связаться с волонтером").callbackData("/callVolunteer")}
                });

        return inlineKeyboard;
    }
}
