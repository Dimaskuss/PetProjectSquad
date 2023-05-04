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
        requestArrayList.add(sendMessage);
        return requestArrayList;
    }
}
