package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class MainHandler {

    private final BotStateContext botStateContext;
    private final UserDataCache userDataCache;

    public List<BaseRequest> handleUpdate(Update update) {

        List<BaseRequest> baseRequestList = new ArrayList<>();

        if (update.message() != null && update.message().text() != null) {
            log.info("New message from User:{}, chatId: {},  with text: {}"
                    , update.message().chat().username()
                    , update.message().chat().id()
                    , update.message().text());
            baseRequestList.addAll(handleInputMessage(update.message()));
        }

        if (update.callbackQuery() != null) {
            log.info("New callbackQuery from User: {} chatId: {}, with data: {}"
                    , update.callbackQuery().from().username()
                    , update.callbackQuery().message().chat().id()
                    , update.callbackQuery().data());
            baseRequestList.addAll(handleQueryMessage(update.callbackQuery()));

        }

        if (update.message() != null
                && update.message().photo() != null
                && (userDataCache.getUsersCurrentBotState(update.message().chat().id()) == BotState.CAT_REPORT_VALIDATE
                || userDataCache.getUsersCurrentBotState(update.message().chat().id()) == BotState.DOG_REPORT_VALIDATE)) {

            log.info("New photo from User:{}, chatId: {}"
                    , update.message().from().username()
                    , update.message().chat().id());

            BotState botState = userDataCache.getUsersCurrentBotState(update.message().chat().id());
            baseRequestList.addAll(botStateContext.processInputMessage(botState, update.message()));
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
        long chatId = message.chat().id();
        BotState botState = BotState.getBotStateMap().getOrDefault(message.text(), userDataCache.getUsersCurrentBotState(chatId));
        userDataCache.setUsersCurrentBotState(chatId, botState);
        return botStateContext.processInputMessage(botState, message);
    }

    public List<BaseRequest> handleQueryMessage(CallbackQuery callbackQuery) {
        long chatId = callbackQuery.message().chat().id();
        BotState botState = BotState.getBotStateMap().getOrDefault(callbackQuery.data(), userDataCache.getUsersCurrentBotState(chatId));
        userDataCache.setUsersCurrentBotState(chatId, botState);
        return botStateContext.processInputQuery(botState, chatId);
    }


}
