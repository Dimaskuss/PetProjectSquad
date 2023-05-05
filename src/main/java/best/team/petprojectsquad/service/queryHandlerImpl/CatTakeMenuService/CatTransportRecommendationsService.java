package best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CatTransportRecommendationsService implements QueryHandlerService {
    /**
     * Метод формирует ответное сообщение на запрос пользователя
     *
     * @param id id пользователя
     * @return ответ пользователю
     */
    @Override
    public List<BaseRequest> getReplyMessage(long id) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Рекомендации по транспортировке кошки:
                1. Используйте специальный переносной контейнер для животных. Он должен быть достаточно большим, чтобы кот мог комфортно сидеть, поворачиваться и ложиться, а также обеспечивать достаточную вентиляцию.
                2. Перед поездкой убедитесь, что кот надежно закрыт в контейнере, чтобы он не мог вырваться во время транспортировки.
                3. Установите контейнер на плоское и стабильное место в транспортном средстве, например, на заднем сиденье автомобиля или на полу самолета.
                4. Обеспечьте коту доступ к воде и еде в течение поездки. Подготовьте миску и бутылку с водой, чтобы он не испытывал дискомфорта и не выходил из строя.
                5. Во время поездки пытайтесь создавать спокойную атмосферу, чтобы кот не испытывал стресс. Включите приятную музыку или успокаивающие звуки.
                6. Если путешествие длительное, то регулярно проверяйте состояние кота, давайте ему возможность выйти из контейнера и осмотреть окружающую среду, прогуляйтесь с ним на поводке, если это возможно.
                7. Если вы путешествуете в другую страну или регион, убедитесь, что у вас есть необходимые документы, такие как ветеринарные сертификаты и прививочные карты, чтобы ваш кот мог безопасно путешествовать.
                """);

        requestArrayList.add(sendMessage);

        return requestArrayList;
    }
 }

