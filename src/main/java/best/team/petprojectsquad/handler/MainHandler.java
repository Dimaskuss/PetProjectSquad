package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.model.CallbackQuery;
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

    private final BotStateContext botStateContext;
    private final best.team.petprojectsquad.Cache.UserDataCache userDataCache;

    public List<BaseRequest> handleUpdate(Update update) {

        List<BaseRequest> baseRequestList = new ArrayList<>();

        Message message = update.message();

        if (update.message() != null && update.message().text() != null) {
            log.info("New message from User:{}, chatId: {},  with text: {}"
                    , message.from().username()
                    , message.chat().id()
                    , message.text());
            baseRequestList.addAll(handleInputMessage(message));
        }

        if (update.callbackQuery() != null) {
            log.info("New callbackQuery from User: {} chatId: {}, with data: {}"
                    , update.callbackQuery().from().username()
                    , update.callbackQuery().message().chat().id()
                    , update.callbackQuery().data());
            baseRequestList.addAll(handleQueryMessage(update.callbackQuery()));

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
            case "/start" -> userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.START);
            case "/info" -> userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.INFO);

            default -> userDataCache.getUsersCurrentBotState(message.chat().id());
        }
        BotState botState = userDataCache.getUsersCurrentBotState(message.chat().id());

        return botStateContext.processInputMessage(botState, message);
    }

    public List<BaseRequest> handleQueryMessage(CallbackQuery callbackQuery) {

        long chatId = callbackQuery.message().chat().id();

        switch (callbackQuery.data()) {
            case "/catShelterMenu" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_SHELTER_MENU);
            case "/dogShelterMenu" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_SHELTER_MENU);
            case "/catShelterAddress" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_SHELTER_ADDRESS);
            case "/dogShelterAddress" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_SHELTER_ADDRESS);
            case "/workSchedule" -> userDataCache.setUsersCurrentBotState(chatId, BotState.WORK_SCHEDULE);
            case "/admissionRules" -> userDataCache.setUsersCurrentBotState(chatId, BotState.ADMISSION_RULES);
            case "/insideRules" -> userDataCache.setUsersCurrentBotState(chatId, BotState.INSIDE_RULES);

            default -> log.error("Нет обработки такого запроса с кнопки:" + callbackQuery.data());
        }
        BotState botState = userDataCache.getUsersCurrentBotState(chatId);

        return botStateContext.processInputQuery(botState, chatId);
    }
}
