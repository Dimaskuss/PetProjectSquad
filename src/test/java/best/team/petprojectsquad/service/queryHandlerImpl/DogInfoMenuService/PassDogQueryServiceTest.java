package best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService;

import best.team.petprojectsquad.service.queryHandlerImpl.DogInfoMenuService.PassDogQueryService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassDogQueryServiceTest {

    private PassDogQueryService service = new PassDogQueryService();
    long id = 1005223990L;

    @Test
    void getReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id,
                "Для оформления пропуска на въезд на территорию приюта свяжитесь, пожалуйста, с охраной, " +
                        "по телефону +7(111)7654321 и сообщите им марку и номер вашего автомобиля, а также дату, " +
                        "когда вы планируете посетить приют.");   expectedArrayList.add(sendMessage);
        List<BaseRequest> actualList = service.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));

    }
}