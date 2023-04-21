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
public class MenuDogQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, " Собачий приют рад приветствовать Вас:");
        Keyboard keyboard = getMainMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }

    private Keyboard getMainMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Узнать информацию о приюте").callbackData("/dogShelterInfoMenu")},
                        {new InlineKeyboardButton("Как взять животное из приюта").callbackData("/dogShelterTakeCatInfo")},
                        {new InlineKeyboardButton("Прислать отчет о питомце").callbackData("/dogReport")},
                        {new InlineKeyboardButton("Позвать волонтера").callbackData("/callVolunteer")}
                });

        return inlineKeyboard;
    }
}
