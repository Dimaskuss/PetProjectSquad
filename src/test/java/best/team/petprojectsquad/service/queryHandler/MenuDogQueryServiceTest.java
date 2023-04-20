package best.team.petprojectsquad.service.queryHandler;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuDogQueryServiceTest {
    private MenuDogQueryService menuDogQueryService = new MenuDogQueryService();
    private static final Long ID = 1005223990L;
    @Test
    void getReplyMessage() {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(ID, " Собачий приют рад приветствовать Вас:");
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("Узнать информацию о приюте").callbackData("/dogShelterInfoMenu")},
                        {new InlineKeyboardButton("Как взять животное из приюта").callbackData("/dogShelterTakeCatInfo")},
                        {new InlineKeyboardButton("Прислать отчет о питомце").callbackData("/dogReport")},
                        {new InlineKeyboardButton("Позвать волонтера").callbackData("/callVolunteer")}
                });
        Keyboard keyboard = inlineKeyboard;
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);
        assertEquals(requestArrayList.get(0).getParameters(), menuDogQueryService.getReplyMessage(ID).get(0).getParameters());
    }
}