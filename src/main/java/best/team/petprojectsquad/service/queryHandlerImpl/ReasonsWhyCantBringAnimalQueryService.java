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

        SendMessage sendMessage0 = new SendMessage(id, "Вам могут отказать по одной из причин:");
        SendMessage sendMessage1 = new SendMessage(id, """
                1. Несоответствие требованием безопасности. Волонтеры ведут некую статистику причин, по которым
                пристроенные питомцы получают травмы.
                2. Адекватность. Отказ от вакцинации и обработки от паразитов.
                3. В доме есть другие животные. С одной стороны, это плюс, значит потенциальный владелец может ухаживать
                за питомцем, с другой - некоторые животные пережили слишком много и плохо адаптируются к соседству.
                4. Вы хотите взять питомца для ребенка. Очень часто родители берут в дом животное, как игрушку для
                ребенка, наиграется - могут выкинуть.
                5. Аллергия. Если Вы аллергик, Вам могут отказать, либо попросят пройти необходимые проверки у врача.
                6. Вы берете питомца в подарок.
                7. Пожилой одинокий человек.
                8. Отсутствие собственного жилья. Дело в том, что не все арендодатели разрешают содержать животных в
                квартире. Даже если Ваш нынешний владелец не против, никто не застрахован от переезда, а между питомцем
                и домом, люди выбирают последнее.
                9. Без объяснения причин. Не всегда волонтеру удобно озвучивать свои опасения.
                  """);

        requestArrayList.add(sendMessage0);
        requestArrayList.add(sendMessage1);

        return requestArrayList;
    }
}
