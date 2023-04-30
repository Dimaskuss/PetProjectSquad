package best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService;

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
public class DogTakeInfoService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Собачий приют приветствует вас. Ниже представлена информация, которая поможет Вам разобраться
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
                                .callbackData("/rulesBeforeGettingDog")},
                        {new InlineKeyboardButton("список документов, необходимых для того, чтобы взять животное из приюта")
                                .callbackData("/dogListOfDocuments")},
                        {new InlineKeyboardButton("список рекомендаций по транспортировке животного")
                                .callbackData("/dogTransportRecommendations")},
                        {new InlineKeyboardButton("список рекомендаций по обустройству дома для щенка")
                                .callbackData("/homeRecommendationsPuppy")},
                        {new InlineKeyboardButton("список рекомендаций по обустройству дома для взрослого животного")
                                .callbackData("/homeRecommendationsAdultDog")},
                        {new InlineKeyboardButton("список рекомендаций по обустройству дома для для животного с " +
                                "ограниченными возможностями").callbackData("/homeRecommendationsDogWithDisabilities")},
                        {new InlineKeyboardButton("советы кинолога по первичному общению с собакой")
                                .callbackData("/tipsDogTrainer")},
                        {new InlineKeyboardButton("рекомендации по проверенным кинологам для дальнейшего обращения к ним")
                                .callbackData("/listVerifiedDogTrainers")},
                        {new InlineKeyboardButton("список причин, почему могут отказать и не дать забрать животное из приюта")
                                .callbackData("/dogListReasonsNegative")},
                        {new InlineKeyboardButton("записать контактные данные для связи")
                                .callbackData("/dogSendContact")},
                        {new InlineKeyboardButton("связаться с волонтером").callbackData("/callVolunteer")}
                });

        return inlineKeyboard;
    }
}
