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
                    , update.message().from().username()
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

        switch (message.text()) {
            case "/start" -> userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.START);
            case "/info" -> userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.INFO);
            case "/superUser" ->
                    userDataCache.setUsersCurrentBotState(message.chat().id(), BotState.SUPER_USER_VOLUNTEER);

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
            case "/catInfoMenu" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_INFO_MENU);
            case "/dogInfoMenu" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_INFO_MENU);
            case "/catInfo" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_SHELTER_INFO);
            case "/dogInfo" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_SHELTER_INFO);
            case "/catAddress" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_SHELTER_ADDRESS);
            case "/dogAddress" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_SHELTER_ADDRESS);
            case "/catPass" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_SHELTER_PASS);
            case "/dogPass" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_SHELTER_PASS);
            case "/catSafety" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_SHELTER_SAFETY);
            case "/dogSafety" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_SHELTER_SAFETY);
            case "/catCallback" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_SHELTER_CALLBACK);
            case "/dogCallback" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_SHELTER_CALLBACK);
            case "/callVolunteer" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CALL_VOLUNTEER);
            case "/reasonsWhy" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.REASONS_WHY_CANT_BRING_AN_ANIMAL);
            case "/catTakeInfo" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_TAKE_INFO);
            case "/dogTakeInfo" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_TAKE_INFO);
            case "/rulesBeforeGettingCat" -> userDataCache.setUsersCurrentBotState(chatId, BotState.RULES_TAKE_CAT);
            case "/rulesBeforeGettingDog" -> userDataCache.setUsersCurrentBotState(chatId, BotState.RULES_TAKE_DOG);
            case "/catListOfDocuments" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_TAKE_DOCUMENTS);
            case "/dogListOfDocuments" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_TAKE_DOCUMENTS);
            case "/catTransportRecommendations" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_TRANSPORT_RECOMMENDATION);
            case "/dogTransportRecommendations" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_TRANSPORT_RECOMMENDATION);
            case "/homeRecommendationsKitten" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.HOME_RECOMMENDATION_KITTEN);
            case "/homeRecommendationsPuppy" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.HOME_RECOMMENDATION_PUPPY);
            case "/homeRecommendationsAdultCat" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.HOME_RECOMMENDATION_ADULT_CAT);
            case "/homeRecommendationsAdultDog" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.HOME_RECOMMENDATION_ADULT_DOG);
            case "/homeRecommendationsCatWithDisabilities" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.HOME_RECOMMENDATION_DIS_CAT);
            case "/homeRecommendationsDogWithDisabilities" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.HOME_RECOMMENDATION_DIS_DOG);
            case "/tipsDogTrainer" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_TIPS_TRAINER);
            case "/listVerifiedDogTrainers" ->
                    userDataCache.setUsersCurrentBotState(chatId, BotState.VERIFIED_TRAINERS);
            case "/catSendContact" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CONTACTS_CAT);
            case "/dogSendContact" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CONTACTS_DOG);
            case "/catReportMenu" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_REPORT_MENU);
            case "/dogReportMenu" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_REPORT_MENU);
            case "/catReport" -> userDataCache.setUsersCurrentBotState(chatId, BotState.CAT_REPORT);
            case "/dogReport" -> userDataCache.setUsersCurrentBotState(chatId, BotState.DOG_REPORT);
            case "/formReport" -> userDataCache.setUsersCurrentBotState(chatId, BotState.FORM_REPORT);

            default -> log.error("Нет обработки такого запроса с кнопки:" + callbackQuery.data());
        }
        BotState botState = userDataCache.getUsersCurrentBotState(chatId);

        return botStateContext.processInputQuery(botState, chatId);
    }


}
