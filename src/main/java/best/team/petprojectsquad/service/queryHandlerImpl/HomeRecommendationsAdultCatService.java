package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HomeRecommendationsAdultCatService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Рекомендаций по обустройству дома для взрослого кота:\n\n" +
                "\n" +
                "1. Кормление: Обеспечьте доступ к свежей воде и корму. Используйте качественный корм для взрослых котов. Кроме того, важно следить за рационом, чтобы он соответствовал возрасту и физическим потребностям вашего кота.\n" +
                "\n" +
                "2. Место для сна: Выделите спокойное место для сна вашего кота, например, мягкую кровать или лежанку. Обеспечьте комфортную температуру и защиту от сквозняков.\n" +
                "\n" +
                "3. Когтеточка: Предоставьте коту когтеточку, чтобы он мог точить когти. Поставьте ее в месте, где кот обычно проводит время, и попробуйте привить ему привычку использовать ее.\n" +
                "\n" +
                "4. Игрушки: Коты любят играть, так что не забывайте об игрушках. Приобретите разнообразные игрушки, которые подойдут для разных видов игр, например, мячики, мыши, игрушки на веревке и т.д.\n" +
                "\n" +
                "5. Туалет: Поставьте лоток для кота в тихом и уединенном месте. Выберите лоток, который подойдет размером для вашего кота, и используйте качественный наполнитель.\n" +
                "\n" +
                "6. Охрана: Обеспечьте безопасность вашего кота. Убедитесь, что окна и двери закрыты, чтобы кот не мог выбраться на улицу. Рассмотрите возможность установки сеток на окнах или использования ошейника с биркой.\n" +
                "\n" +
                "7. Пространство: Предоставьте коту достаточно места для передвижения. Разместите игрушки и лежанки в разных местах, чтобы кот мог развлекаться и отдыхать.\n" +
                "\n" +
                "8. Уборка: Убирайте лоток и места, где кот обычно проводит время, чтобы поддерживать чистоту дома. Регулярно проветривайте помещение и используйте моющие средства без вредных для здоровья кота химических веществ.");
        requestArrayList.add(sendMessage);


        return requestArrayList;
    }
}