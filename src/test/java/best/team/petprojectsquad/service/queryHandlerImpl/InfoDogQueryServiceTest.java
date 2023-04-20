package best.team.petprojectsquad.service.queryHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InfoDogQueryServiceTest {

    private InfoDogQueryService infoDogQueryService = new InfoDogQueryService();
    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendPhoto sendPhoto = new SendPhoto(id, "pictures/infoDogShelter.png");
        SendMessage sendMessage = new SendMessage(id,
                "Наш приют основан на принципах сострадания, заботы и ответственности." +
                        "Мы предоставляем безопасное место для временного содержания бездомных собак, которые были брошены," +
                        "потеряны или находятся в неблагоприятных условиях. Мы предоставляем им качественный уход, включая регулярное питание," +
                        "медицинское обслуживание и физические тренировки, чтобы они были здоровы и готовы к новому дому.");
        expectedArrayList.add(sendPhoto);
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = infoDogQueryService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));


    }
}