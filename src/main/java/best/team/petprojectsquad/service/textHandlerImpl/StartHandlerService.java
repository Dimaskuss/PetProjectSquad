package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class StartHandlerService implements TextHandlerService {
    UserRepository userRepository;

    public StartHandlerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        Keyboard keyboard = getMainMenuKeyboard();
        if (!userRepository.existsByChatId(message.chat().id())) {
            User user = new User(message.chat().id(),message.from().username());
            userRepository.save(user);
            SendPhoto sendPhoto = new SendPhoto(message.chat().id(), new File("src/main/resources/mainMenu.png"));
            sendPhoto.caption("""
                    Вас приветствует приют для домашних животных.
                    Наш приют содержит бездомных, покалеченных и больных животных (без учёта постоянно прибывающих) и
                    очень нуждается в помощи и благотворительности на постоянной основе. Будем признательны за каждый
                    вклад.
                    Если вы неравнодушны, приезжайте общаться с хвостиками, привезите им вкусняшки, помогите копейкой, 
                    им же немного нужно для счастья. А самое большое счастье для четвероногого друга - обрести свой 
                    родной дом или чью-то родную душу.
                    Мы очень будем рады любой помощи.
                    """);
            requestArrayList.add(sendPhoto);
        }
        SendMessage sendMessage = new SendMessage(message.chat().id(), "Выберите интересующий Вас приют:");
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }

    private Keyboard getMainMenuKeyboard() {

        InlineKeyboardButton button1 = new InlineKeyboardButton("Кошачий приют");
        button1.callbackData("/catShelterMenu");

        InlineKeyboardButton button2 = new InlineKeyboardButton("Собачий приют");
        button2.callbackData("/dogShelterMenu");

        InlineKeyboardButton[] row1 = new InlineKeyboardButton[]{button1, button2};

        Keyboard replyKeyboard = new InlineKeyboardMarkup(row1);

        return replyKeyboard;
    }
}