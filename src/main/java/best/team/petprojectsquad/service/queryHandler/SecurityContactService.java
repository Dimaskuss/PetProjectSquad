package best.team.petprojectsquad.service.queryHandler;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SecurityContactService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Контактные данные охраны для оформления пропуска на машину...");
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }
}
