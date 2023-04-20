package best.team.petprojectsquad.service.queryHandler;
import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdmissionRulesService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Правило 1
                Правило 2
                Правило 3
                """);
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }
}
