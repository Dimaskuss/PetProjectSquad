package best.team.petprojectsquad.service.queryHandlerImpl;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReasonsWhyCantBringAnimalQueryServiceTest {
    @Autowired
    ReasonsWhyCantBringAnimalQueryService reasonsWhyCantBringAnimalQueryService;
    long id = 123;
    @Test
    void getReplyMessage() {
        List<BaseRequest> replyMessage = reasonsWhyCantBringAnimalQueryService.getReplyMessage(123);
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "На территории приюта, просим следовать правилам, которые могут помочь обеспечить безопасность животных и посетителей:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Несоответствие требованием безопасности\n" + "Волонтеры ведут некую статистику причин, по которым пристроенные питомцы получают травмы");
        SendMessage sendMessage2 = new SendMessage(id, "2. Адекватность\n" +
                                                       "Отказ от вакцинации и обработки от паразитов");
        SendMessage sendMessage3 = new SendMessage(id, "3. В доме есть другие животные\n" +
                                                       "С одной стороны, это плюс, значит потенциальный владелец может ухаживать за питомцем, с другой - некоторые животные пережили слишком много и плохо адаптируются к соседству.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Вы хотите взять питомца для ребенка\n" +
                                                       "Очень часто родители берут в дом животное, как игрушку для ребенка, наиграется - могут выкинуть.");
        SendMessage sendMessage5 = new SendMessage(id, "5. Аллергия\n" +
                                                       "Если Вы аллергик, Вам могут отказать, либо попросят пройти необходимые проверки у врача. ");
        SendMessage sendMessage6 = new SendMessage(id, "6. Вы берете питомца в подарок");
        SendMessage sendMessage7 = new SendMessage(id, "7. Пожилой одинокий человек");
        SendMessage sendMessage8 = new SendMessage(id, "8. Отсутствие собственного жилья\n" +
                                                       "Дело в том, что не все арендодатели разрешают содержать животных в квартире. Даже если Ваш нынешний владелец не против, никто не застрахован от переезда, а между питомцем и домом, люди выбирают последнее.");
        SendMessage sendMessage9 = new SendMessage(id, "9. Без объяснения причин\n" +
                                                       "Не всегда волонтеру удобно озвучивать свои опасения.");
        requestArrayList.add(sendMessage0);
        requestArrayList.add(sendMessage1);
        requestArrayList.add(sendMessage2);
        requestArrayList.add(sendMessage3);
        requestArrayList.add(sendMessage4);
        requestArrayList.add(sendMessage5);
        requestArrayList.add(sendMessage6);
        requestArrayList.add(sendMessage7);
        requestArrayList.add(sendMessage8);
        requestArrayList.add(sendMessage9);

        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
        assertEquals(replyMessage.get(1).getParameters(), requestArrayList.get(1).getParameters());
        assertEquals(replyMessage.get(2).getParameters(), requestArrayList.get(2).getParameters());
        assertEquals(replyMessage.get(3).getParameters(), requestArrayList.get(3).getParameters());
        assertEquals(replyMessage.get(4).getParameters(), requestArrayList.get(4).getParameters());
        assertEquals(replyMessage.get(5).getParameters(), requestArrayList.get(5).getParameters());
        assertEquals(replyMessage.get(6).getParameters(), requestArrayList.get(6).getParameters());
        assertEquals(replyMessage.get(7).getParameters(), requestArrayList.get(7).getParameters());
        assertEquals(replyMessage.get(8).getParameters(), requestArrayList.get(8).getParameters());
    }
}