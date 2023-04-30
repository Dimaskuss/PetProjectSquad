package best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassDogQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id,
                "Для оформления пропуска на въезд на территорию приюта свяжитесь, пожалуйста, с охраной, " +
                        "по телефону +7(111)7654321 и сообщите им марку и номер вашего автомобиля, а также дату, " +
                        "когда вы планируете посетить приют.");
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }

}