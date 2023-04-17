package best.team.petprojectsquad.service.queryHandler;

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
public class MenuCatQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Кошачий приют рад приветствовать Вас:");
        Keyboard keyboard = getMainMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);
        return requestArrayList;

    }

    private Keyboard getMainMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Узнать информацию о приюте").callbackData("/catShelterInfoMenu")},
                        {new InlineKeyboardButton("Как взять животное из приюта").callbackData("/catShelterTakeCatInfo")},
                        {new InlineKeyboardButton("Прислать отчет о питомце").callbackData("/catReport")},
                        {new InlineKeyboardButton("Позвать волонтера").callbackData("/callVolunteer")}
                });

        return inlineKeyboard;
    }
}
