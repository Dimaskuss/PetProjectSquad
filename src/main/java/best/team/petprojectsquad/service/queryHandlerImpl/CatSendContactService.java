package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatSendContactService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        return null;
    }
}
