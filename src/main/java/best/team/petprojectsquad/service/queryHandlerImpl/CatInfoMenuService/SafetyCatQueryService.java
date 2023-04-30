package best.team.petprojectsquad.service.queryHandlerImpl.CatInfoMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SafetyCatQueryService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        SendMessage sendMessage0 = new SendMessage(id, "На территории приюта для кошек, просим следовать правилам, которые могут помочь обеспечить безопасность животных и посетителей:");
        SendMessage sendMessage1 = new SendMessage(id, "1. Запрет на кормление животных, запрет на использование вспышек фотоаппаратов, а также доступ в служебные помещения.");
        SendMessage sendMessage2 = new SendMessage(id, "2. Не приближайтесь к кошкам, не выставляйте руки и не пытайтесь их погладить, не разрешив этого сотрудникам приюта. Некоторые животные могут быть напуганы посторонними людьми и реагировать агрессивно.");
        SendMessage sendMessage3 = new SendMessage(id, "3. Не подходите к клеткам или вольерам ближе, чем на рекомендуемое расстояние. Некоторые кошки могут быть агрессивны, особенно если они чувствуют себя напуганными или защищают свою территорию.");
        SendMessage sendMessage4 = new SendMessage(id, "4. Если вы не уверены, как вести себя с животными в приюте, спросите у персонала. Они могут дать вам инструкции, которые помогут вам избежать конфликта с животными и обеспечить вашу безопасность.");

        requestArrayList.add(sendMessage0);
        requestArrayList.add(sendMessage1);
        requestArrayList.add(sendMessage2);
        requestArrayList.add(sendMessage3);
        requestArrayList.add(sendMessage4);

        return requestArrayList;
    }

}