package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MainHandler {

    private final BotStateContext botStateContext;
    private final UserDataCache userDataCache;


    public SendMessage handleUpdate(Update update) {

        SendMessage replyMessage = null;

        Message message = update.message();

        if (update.message() != null && update.message().text() != null) {
            log.info("New message from User:{}, chatId: {},  with text: {}"
                    , message.from().username()
                    , message.chat().id(), message.text());
            replyMessage = handleInputMessage(message);
        }

        return replyMessage;
    }


    public SendMessage handleInputMessage(Message message) {
        String inputText = message.text();
        long userId = message.chat().id();
        SendMessage replyMessage;

        switch (inputText) {
            case "/start" -> userDataCache.setUsersCurrentBotState(userId, BotState.START);
            case "/info" -> userDataCache.setUsersCurrentBotState(userId, BotState.INFO);
            default -> userDataCache.getUsersCurrentBotState(userId);
        }

        BotState botState = userDataCache.getUsersCurrentBotState(userId);

        replyMessage = botStateContext.processInputMessage(botState, message);

        return replyMessage;
    }

}
