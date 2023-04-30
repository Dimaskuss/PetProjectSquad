package best.team.petprojectsquad.service.queryHandlerImpl.CatInfoMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoCatQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendPhoto sendPhoto = new SendPhoto(id, "pictures/infoCatShelter.png");
        SendMessage sendMessage = new SendMessage(id,
                "Наш приют чистый и ухоженный.\n" +
                        "Поэтому играть с котиками и проводить время — отдых и одно удовольствие.\n" +
                        "Но из-за того, что люди воспринимают приюты только как боль и страдание, гостей у нас немного. И котам одиноко.\n" +
                        "Сделает ли вас посещение приюта счастливее?\n" +
                        "Определенно, Вы почувствуете, что день прожили не зря.");
        requestArrayList.add(sendPhoto);
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }

}