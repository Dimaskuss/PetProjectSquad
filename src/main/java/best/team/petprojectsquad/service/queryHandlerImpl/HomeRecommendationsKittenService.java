package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HomeRecommendationsKittenService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Рекомендации по обустройству дома для котенка:\n\n" +
                "\n" +
                "1. Безопасность дома: Проверьте дом на наличие опасных для котенка предметов, например, открытых окон или проводов, которые можно быстро убрать или закрыть.\n" +
                "\n" +
                "2. Игрушки: Обеспечьте котенку достаточное количество игрушек, чтобы он мог развиваться и играть в безопасной обстановке. Котята любят разнообразные игрушки, поэтому имеет смысл купить несколько разных.\n" +
                "\n" +
                "3. Лоток: Купите лоток для котенка и научите его использовать его, чтобы избежать проблем со справлением нужд. Лоток должен быть доступен для котенка в любое время, и вы должны регулярно его чистить.\n" +
                "\n" +
                "4. Когтеточка: Купите когтеточку для котенка, чтобы он мог точить когти и избежать повреждения мебели и других предметов в доме.\n" +
                "\n" +
                "5. Место для отдыха: Обеспечьте котенку уютное место для сна и отдыха, где он может чувствовать себя комфортно.\n" +
                "\n" +
                "6. Корм: Выберите правильный корм для котенка, который будет соответствовать его возрасту и потребностям в питании. Обратитесь к ветеринару, чтобы получить рекомендации по кормлению котенка.\n" +
                "\n" +
                "7. Вода: Поставьте миску с чистой водой в доступном месте для котенка, чтобы он мог пить воду в любое время.\n" +
                "\n" +
                "8. Ветеринар: Найдите хорошего ветеринара и посещайте его регулярно для профилактических осмотров и вакцинации.\n" +
                "\n" +
                "9. Здоровье: Следите за здоровьем котенка и проводите профилактические мероприятия, такие как обработка от паразитов и вакцинация. Также следуйте рекомендациям ветеринара по уходу за котенком и лечению возможных заболеваний.\n" +
                "\n" +
                "10. Обучение: Научите котенка ходить на поводке и приучайте его к правилам поведения в доме. Например, запретите ему царапать мебель или залезать на столы.\n" +
                "\n" +
                "11. Изоляция: Изолируйте котенка в небольшом помещении на первое время, чтобы он мог привыкнуть к новому дому и избежать стресса от слишком большого пространства.\n" +
                "\n" +
                "12. Общение: Проводите время с котенком, играйте с ним, ласкайте и гладьте, чтобы он чувствовал себя любимым и защищенным.\n" +
                "\n" +
                "13. Ответственность: Будьте ответственным хозяином, обеспечьте котенку все необходимое и не забывайте следить за его здоровьем и благополучием.\n" +
                "\n" +
                "14. Наблюдение: Следите за поведением котенка, его аппетитом и активностью, чтобы своевременно обнаружить возможные проблемы и заболевания.\n" +
                "\n" +
                "15. Общение с ветеринаром: Связывайтесь с ветеринаром, если у котенка появляются проблемы с пищеварением, дыханием или другие симптомы, требующие вмешательства профессионала.\n" +
                "\n" +
                "16. Подготовка к поездкам: Приготовьте транспортную клетку и другие необходимые предметы, если вы планируете совершать поездки с котенком.\n" +
                "\n" +
                "17. Уход за шерстью: Регулярно чистите шерсть котенка с помощью щетки или расчески, чтобы избежать образования комков и помочь ему сохранять здоровую и блестящую шерсть.\n" +
                "\n" +
                "18. Уборка: Регулярно убирайте квартиру, чтобы избежать накопления шерсти, пыли и грязи, которые могут навредить здоровью котенка.\n" +
                "\n" +
                "19. Обеспечение активности: Проводите с котенком время на свежем воздухе, играйте с ним и обеспечьте ему достаточную физическую активность, чтобы он мог развиваться и расти здоровым и сильным.\n" +
                "\n" +
                "20. Первая помощь: Изучите базовые методы оказания первой помощи котенку, чтобы быстро реагировать в случае необходимости.");
        requestArrayList.add(sendMessage);


        return requestArrayList;
    }
}
