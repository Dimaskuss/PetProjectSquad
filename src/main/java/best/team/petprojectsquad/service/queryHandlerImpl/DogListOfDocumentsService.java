package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogListOfDocumentsService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        //todo: РЕАЛИЗОВАТЬ ОТДЕЛЬНО ДЛЯ КОШЕК И СОБАК ИЛИ СДЕЛАТЬ ОБЩИЙ КЛАСС И СЕРВИС ?
        return null;
    }
}
