package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReasonsWhyCantBringAnimalQueryService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "На территории приюта, просим следовать правилам, которые могут помочь обеспечить безопасность животных и посетителей:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Несоответствие требованием безопасности" + "Волонтеры ведут некую статистику причин, по которым пристроенные питомцы получают травмы");
        SendMessage sendMessage2 = new SendMessage(id, "2. Адекватность" +
                                                       "Отказ от вакцинации и обработки от паразитов");
        SendMessage sendMessage3 = new SendMessage(id, "3. В доме есть другие животные" +
                                                       "С одной стороны, это плюс, значит потенциальный владелец может ухаживать за питомцем, с другой - некоторые животные пережили слишком много и плохо адаптируются к соседству.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Вы хотите взять питомца для ребенка" +
                                                       "Очень часто родители берут в дом животное, как игрушку для ребенка, наиграется - могут выкинуть.");
        SendMessage sendMessage5 = new SendMessage(id, "5. Аллергия" +
                                                       "Если Вы аллергик, Вам могут отказать, либо попросят пройти необходимые проверки у врача. ");
        SendMessage sendMessage6 = new SendMessage(id, "6. Вы берете питомца в подарок");
        SendMessage sendMessage7 = new SendMessage(id, "7. Пожилой одинокий человек");
        SendMessage sendMessage8 = new SendMessage(id, "8. Отсутствие собственного жилья" +
                                                       "Дело в том, что не все арендодатели разрешают содержать животных в квартире. Даже если Ваш нынешний владелец не против, никто не застрахован от переезда, а между питомцем и домом, люди выбирают последнее.");
        SendMessage sendMessage9 = new SendMessage(id, "9. Без объяснения причин" +
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

        return requestArrayList;
    }
}
