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
public class ReportService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Пришлите фотографию питомца, в описание к фото добавьте
                следующую информацию:
                - Рацион животного.
                - Общее самочувствие и привыкание к новому месту.
                - Изменение в поведении: отказ от старых привычек, приобретение новых.
                Пример:
                """);
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/pictures/report.png"));
        sendPhoto.caption("Кормим питомца: корм/бренд, питомец чувствует себя прекрасно, ведет себя ласково и дружелюбно.");
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);
        return requestArrayList;
    }
}
