package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressDogQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage0 = new SendMessage(id, "Адрес: г. Первый, ул. Соседняя дом 15.");
        SendMessage sendMessage1 = new SendMessage(id, "Рабочие часы приюта для собак:\nПонедельник - Пятница: 10:00 - 17:00\nСуббота - Воскресенье: 12:00 - 16:00\nCхема проезда:");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/pictures/addressDog.png"));
        requestArrayList.add(sendMessage0);
        requestArrayList.add(sendMessage1);
        requestArrayList.add(sendPhoto);
        return requestArrayList;
    }
}
