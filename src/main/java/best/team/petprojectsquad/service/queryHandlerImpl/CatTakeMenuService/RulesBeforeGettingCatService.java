package best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RulesBeforeGettingCatService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "Перед забиранием кошки из приюта, важно убедиться, что вы готовы к ответственности за нового питомца. Также необходимо знать, как правильно знакомиться с кошкой, " +
                "чтобы установить с ней контакт и сделать переезд в новый дом более комфортным.\nВот несколько правил знакомства с кошкой:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Не беспокойте кошку: Кошки могут быть очень скрытными и пугливыми");
        SendMessage sendMessage2 = new SendMessage(id, "2. Подходите к кошке сбоку: Подойдите к кошке сбоку, чтобы она могла увидеть вас и понюхать вас.");
        SendMessage sendMessage3 = new SendMessage(id, "3. Говорите с кошкой мягким и спокойным голосом.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Игрушки могут помочь в установлении контакта с кошкой.");

        requestArrayList.add(sendMessage0);
        requestArrayList.add(sendMessage1);
        requestArrayList.add(sendMessage2);
        requestArrayList.add(sendMessage3);
        requestArrayList.add(sendMessage4);

        return requestArrayList;
    }

}

