package best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RulesBeforeGettingDogService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "Когда вы планируете забрать собаку из приюта, очень важно правильно знакомиться с ней и установить с ней контакт. Таким образом, собака будет чувствовать себя комфортно и безопасно," +
                " когда переедет к вам домой.\nВот несколько правил знакомства с собакой:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Подходите к собаке медленно и спокойно: Не подходите к собаке слишком быстро или слишком близко.");
        SendMessage sendMessage2 = new SendMessage(id, "2. Наклонение над собакой может быть воспринято ею как угроза.");
        SendMessage sendMessage3 = new SendMessage(id, "3. Говорите с собакой мягким и спокойным голосом.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Лакомства могут помочь в установлении контакта с собакой.");

        requestArrayList.add(sendMessage0);
        requestArrayList.add(sendMessage1);
        requestArrayList.add(sendMessage2);
        requestArrayList.add(sendMessage3);
        requestArrayList.add(sendMessage4);

        return requestArrayList;
    }
}
