package best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoDogQueryService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendPhoto sendPhoto = new SendPhoto(id, "pictures/infoDogShelter.png");
        SendMessage sendMessage = new SendMessage(id,
                "Наш приют основан на принципах сострадания, заботы и ответственности." +
                        "Мы предоставляем безопасное место для временного содержания бездомных собак, которые были брошены," +
                        "потеряны или находятся в неблагоприятных условиях. Мы предоставляем им качественный уход, включая регулярное питание," +
                        "медицинское обслуживание и физические тренировки, чтобы они были здоровы и готовы к новому дому.");
        requestArrayList.add(sendPhoto);
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }

}