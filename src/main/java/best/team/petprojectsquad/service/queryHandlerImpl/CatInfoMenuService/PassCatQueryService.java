package best.team.petprojectsquad.service.queryHandlerImpl.CatInfoMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassCatQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id,
                "Для оформления пропуска на въезд на территорию приюта свяжитесь, пожалуйста, с охраной, " +
                        "по телефону +7(777)1234567 и сообщите им марку и номер вашего автомобиля, а также дату, " +
                        "когда вы планируете посетить приют.");
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }

}