package best.team.petprojectsquad.service.queryHandler;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuDogQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        return null;
    }
}
