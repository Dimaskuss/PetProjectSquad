package best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogTransportRecommendationsService implements QueryHandlerService {
  @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Рекомендации по транспортировке собаки
                1. Используйте специальный переносной контейнер для животных. Он должен быть достаточно большим, чтобы собака могла комфортно сидеть, поворачиваться и ложиться, а также обеспечивать достаточную вентиляцию.
                2. Перед поездкой убедитесь, что собака надежно закрыта в контейнере, чтобы она не могла вырваться во время транспортировки.
                3. Установите контейнер на плоское и стабильное место в транспортном средстве, например, на заднем сиденье автомобиля или на полу самолета.
                4. Обеспечьте собаке доступ к воде и еде в течение поездки. Подготовьте миску и бутылку с водой, чтобы она не испытывала дискомфорта и не выходила из строя.
                5. Во время поездки пытайтесь создавать спокойную атмосферу, чтобы собака не испытывала стресс. Включите приятную музыку или успокаивающие звуки.
                6. Если путешествие длительное, то регулярно проверяйте состояние собаки, давайте ей возможность выйти из контейнера и осмотреть окружающую среду, прогуляйтесь с ней на поводке, если это возможно.
                7. Если вы путешествуете в другую страну или регион, убедитесь, что у вас есть необходимые документы, такие как ветеринарные сертификаты и прививочные карты, чтобы ваша собака могла безопасно путешествовать.
                8. Если вы путешествуете на автомобиле, то не оставляйте собаку в машине на длительное время в жаркую погоду, даже если окна приоткрыты, потому что это может привести к перегреву и опасно для здоровья животного.
                """);

        requestArrayList.add(sendMessage);


        return requestArrayList;
    }
}