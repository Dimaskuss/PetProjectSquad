package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MainHandler {

    //класс основной распределитель для входящих сообщений

    private final BotStateContext botStateContext;
    private final UserDataCache userDataCache;


    public List<BaseRequest> handleUpdate(Update update) {

        //создали Лист который будем возвращать
        List<BaseRequest> baseRequestList = new ArrayList<>();

        Message message = update.message();

        //в данном случае мы проверяем только на текст, если есть то обрабатываем
        if (update.message() != null && update.message().text() != null) {
            //фиксируем в логах что пришло сообщение
            log.info("New message from User:{}, chatId: {},  with text: {}"
                    , message.from().username()
                    , message.chat().id(), message.text());
            // передаем уже сообщение в обработку
            baseRequestList.addAll(handleInputMessage(message));
        }

        return baseRequestList;
    }


    /**
     * Обработка сообщения, полученного от пользователя
     *
     * @param message сообщение пользователя
     * @return ответ пользователю
     */
    public List<BaseRequest> handleInputMessage(Message message) {

        //извлекаем из сообщения текст
        switch (message.text()) {
            //если текст старт то назначаем статус бота старт
            case "/start" -> userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.START);
            case "/info" -> userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.INFO);
            //если ни один из кейсов выше не подошел то вытаскиваем текущий статус бота,
            // это понадобиться дальше когда нужно будет обрабатывать входязие от пользователя данные
            // к примеру мы запросили у пользователя номер телефона и назначили боту статус проверка
            // телефона "VOLIDATE_PHONE", пользователь присылает нам текст с номером телефона, номер
            // телефона естественно не совпадет ни с одним из кейсов (а так как номер телефона это String
            // он попадет именно в этот метод) из строчки ниже будет
            // определен статус бота "VOLIDATE_PHONE" и по этому статусу мы выдерним из контекста
            // нужный нам класс обработчик
            default -> userDataCache.getUsersCurrentBotState(message.chat().id());
        }

        BotState botState = userDataCache.getUsersCurrentBotState(message.chat().id());


        // сюда передаем наш статус бота и сообщение , сообщение передаем так как оно может содержать не только /start или /info
        // но и номер делефона и другие данные которые возможно нам надо будет рапарсить в дальнейшем
        return botStateContext.processInputMessage(botState, message);
    }

}
