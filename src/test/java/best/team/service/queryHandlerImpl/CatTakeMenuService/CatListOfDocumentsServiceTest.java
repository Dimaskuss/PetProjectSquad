package best.team.service.queryHandlerImpl.CatTakeMenuService;

import best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService.CatListOfDocumentsService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatListOfDocumentsServiceTest {

    private final CatListOfDocumentsService service = new CatListOfDocumentsService();
    long id = 1005223990L;

    @Test
    void shouldCreateReplyMessage() {

        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id,
                """
                        Список необходимых документов следующий:
                        1) Паспорт;
                        2) Местная регистрация;
                        3) Документ, подтверждающий наличие собственного жилья;
                        4) Согласие всех членов семьи, которые будут проживать с питомцем
                        (никто не хочет, чтобы от животного отказались из-за аллергии родственника).
                        После того как вы выбрали питомца и познакомились с ним, а также доказали, что ему будет с вами хорошо,
                        приют заключает с вами договор о передаче животного и об ответственном содержании.
                        Если обстоятельства не позволяют вам взять животное домой, можно стать волонтером,
                        помощь которых особенно требуется приютам.
                                                                        """);
        expectedArrayList.add(sendMessage);

        List<BaseRequest> actualList = service.getReplyMessage(id);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(0).getParameters().get("chat_id"),expectedArrayList.get(0).getParameters().get("chat_id"));

    }
}