package best.team.petprojectsquad.service.queryHandler;

import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import java.util.ArrayList;
import java.util.List;

public class DogShelterInfoService implements TextHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id, String message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Могу предоставить некоторую информацию о приюте:");
        Keyboard keyboard = getMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }

    private Keyboard getMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Где он находится").callbackData("/dogShelterAddress")},
                        {new InlineKeyboardButton("Как и когда работает").callbackData("/workSchedule")},
                        {new InlineKeyboardButton("Какие правила пропуска на территорию приюта").callbackData("/admissionRules")},
                        {new InlineKeyboardButton("Правила нахождения внутри и общения с животным").callbackData("/insideRules")}
                });

        return inlineKeyboard;
    }
}
