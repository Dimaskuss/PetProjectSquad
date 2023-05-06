package best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SafetyDogQueryService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "На территории приюта для собак, просим следовать правилам, которые могут помочь обеспечить безопасность животных и посетителей:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Запрет на кормление животных, запрет на использование вспышек фотоаппаратов, а также доступ в служебные помещения.");
        SendMessage sendMessage2 = new SendMessage(id, "2. Не приближайтесь к собакам без разрешения: пожалуйста, не приближайтесь к собакам, не выставляйте руки и не пытайтесь их погладить, не разрешив этого сотрудникам приюта. Некоторые животные могут быть напуганы посторонними людьми и реагировать агрессивно.");
        SendMessage sendMessage3 = new SendMessage(id, "3. Соблюдайте личную гигиену: перед посещением приюта убедитесь, что вы чисты, вам не следует посещать приют, если вы болеете.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Если вы не уверены, как вести себя с животными в приюте, спросите у персонала. Они могут дать вам инструкции, которые помогут вам избежать конфликта с животными и обеспечить вашу безопасность.");

        requestArrayList.add(sendMessage0);
        requestArrayList.add(sendMessage1);
        requestArrayList.add(sendMessage2);
        requestArrayList.add(sendMessage3);
        requestArrayList.add(sendMessage4);

        return requestArrayList;
    }

}