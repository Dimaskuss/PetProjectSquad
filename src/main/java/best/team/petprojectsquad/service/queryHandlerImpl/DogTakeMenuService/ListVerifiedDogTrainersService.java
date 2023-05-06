package best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListVerifiedDogTrainersService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Актуальный список проверенных кинологов вы можете получить у наших волонтеров,
                так же вы можете найти кинолога самостоятельно на следующих ресурсах:
                https://k-9.kz/
                https://www.olx.kz/
                """);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }
}
