package best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatListOfDocumentsService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id,
                """
                        Это список документов, которые помогут Вам забрать животное из приюта:
                        документ 1,
                        документ 2,
                        документ 3;
                        """);
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }
}
