package best.team.petprojectsquad.service.queryHandlerImpl.CatInfoMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressCatQueryService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage0 = new SendMessage(id, "Адрес: г. Первый, ул. Средняя дом 8.");
        SendMessage sendMessage1 = new SendMessage(id, "Рабочие часы приюта для кошек:\nПонедельник - Пятница: 10:00 - 19:00\nСуббота - Воскресенье: 11:00 - 17:00\nCхема проезда:");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/pictures/addressCat.png"));
        requestArrayList.add(sendMessage0);
        requestArrayList.add(sendMessage1);
        requestArrayList.add(sendPhoto);
        return requestArrayList;
    }
}
