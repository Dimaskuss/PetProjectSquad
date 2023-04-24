package best.team.petprojectsquad.service.queryHandlerImpl;

import best.team.petprojectsquad.service.QueryHandlerService;
import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Service
public class CatTransportRecommendationsService implements QueryHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Рекомендации по транспортировке кошки \n\n" +
                "1. Используйте специальный переносной контейнер для животных. Он должен быть достаточно большим, чтобы кот мог комфортно сидеть, поворачиваться и ложиться, а также обеспечивать достаточную вентиляцию.\n" +
                "\n" +
                "2. Перед поездкой убедитесь, что кот надежно закрыт в контейнере, чтобы он не мог вырваться во время транспортировки.\n" +
                "\n" +
                "3. Установите контейнер на плоское и стабильное место в транспортном средстве, например, на заднем сиденье автомобиля или на полу самолета.\n" +
                "\n" +
                "4. Обеспечьте коту доступ к воде и еде в течение поездки. Подготовьте миску и бутылку с водой, чтобы он не испытывал дискомфорта и не выходил из строя.\n" +
                "\n" +
                "5. Во время поездки пытайтесь создавать спокойную атмосферу, чтобы кот не испытывал стресс. Включите приятную музыку или успокаивающие звуки.\n" +
                "\n" +
                "6. Если путешествие длительное, то регулярно проверяйте состояние кота, давайте ему возможность выйти из контейнера и осмотреть окружающую среду, прогуляйтесь с ним на поводке, если это возможно.\n" +
                "\n" +
                "7. Если вы путешествуете в другую страну или регион, убедитесь, что у вас есть необходимые документы, такие как ветеринарные сертификаты и прививочные карты, чтобы ваш кот мог безопасно путешествовать.");

        requestArrayList.add(sendMessage);


        return requestArrayList;
    }
    }


