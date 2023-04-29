package best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HomeRecommendationsDogWithDisabilitiesService implements QueryHandlerService {
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Собачий приют приветствует вас. Ниже представлены рекомендации по обустройству дома для 
                животного с ограниченными возможностями (зрение, передвижение):
                Рекомендация 1,
                Рекомендация 2,
                Рекомендация 3;
                """);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }
}
