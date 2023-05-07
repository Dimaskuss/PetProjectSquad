package best.team.petprojectsquad.service.queryHandlerImpl.CatInfoMenuService;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InfoCatQueryServiceTest {

    private InfoCatQueryService infoCatQueryService = new InfoCatQueryService();
    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendPhoto sendPhoto = new SendPhoto(id, "pictures/infoCatShelter.png");
        SendMessage sendMessage = new SendMessage(id,
                "Наш приют чистый и ухоженный.\n" +
                        "Поэтому играть с котиками и проводить время — отдых и одно удовольствие.\n" +
                        "Но из-за того, что люди воспринимают приюты только как боль и страдание, гостей у нас немного. И котам одиноко.\n" +
                        "Сделает ли вас посещение приюта счастливее?\n" +
                        "Определенно, Вы почувствуете, что день прожили не зря.");
        expectedArrayList.add(sendPhoto);
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = infoCatQueryService.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));


    }
}