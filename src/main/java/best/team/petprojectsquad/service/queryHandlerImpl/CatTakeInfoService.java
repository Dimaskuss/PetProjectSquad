package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class CatTakeInfoService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Кошачий приют приветствует вас. Ниже представлена информация, которая поможет Вам разобраться
                с бюрократическими (оформление договора)
                и бытовыми (как подготовиться к жизни с животным) вопросами:
                """);
        Keyboard keyboard = getTakeInfoCatMenuKeyboard();
        sendMessage.replyMarkup(keyboard);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }

    private Keyboard getTakeInfoCatMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[][]{
                        {new InlineKeyboardButton("правила знакомства с животным до того, как забрать его из приюта")
                                .callbackData("/rulesBeforeGettingCat")},
                        {new InlineKeyboardButton("список документов, необходимых для того, чтобы взять животное из приюта")
                                .callbackData("/catListOfDocuments")},
                        {new InlineKeyboardButton("список рекомендаций по транспортировке животного")
                                .callbackData("/catTransportRecommendations")},
                        {new InlineKeyboardButton("список рекомендаций по обустройству дома для котенка")
                                .callbackData("/homeRecommendationsKitten")},
                        {new InlineKeyboardButton("список рекомендаций по обустройству дома для взрослого животного")
                                .callbackData("/homeRecommendationsAdultCat")},
                        {new InlineKeyboardButton("список рекомендаций по обустройству дома для для животного с " +
                                "ограниченными возможностями").callbackData("/homeRecommendationsCatWithDisabilities")},
                        {new InlineKeyboardButton("список причин, почему могут отказать и не дать забрать животное из приюта")
                                .callbackData("/catListReasonsNegative")},
                        {new InlineKeyboardButton("записать контактные данные для связи")
                                .callbackData("/catSendContact")},
                        {new InlineKeyboardButton("связаться с волонтером").callbackData("/callVolunteer")}
                });

        return inlineKeyboard;
    }
}
