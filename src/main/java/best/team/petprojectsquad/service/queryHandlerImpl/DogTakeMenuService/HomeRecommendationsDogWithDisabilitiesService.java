package best.team.petprojectsquad.service.queryHandlerImpl.DogTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeRecommendationsDogWithDisabilitiesService implements QueryHandlerService {
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
                Собаки с ограниченными возможности особенно нуждаются во внимании, но пусть это вас не пугает.
                Порой слепую или глухую собаку не отличить по поведению от полностью здоровой, а песик без лапки может бегать не хуже четырехногого.
                Недостаток одной лапы собаки компенсируют довольно быстро, научившись ходить и даже бегать на трех ногах.
                Длительные прогулки, активные виды спорта и прыжки в высоту под запретом для таких питомцев. Однако не надо впадать в крайность.
                Недостаток движения и обильная калорийная пища могут привести к ожирению и болезням внутренних органов у животного.
                Еще одной достаточно распространенной проблемой является потеря зрения или слуха животного. Чаще всего это происходит
                в старости, но иногда, в случае травмы или врожденных патологий, этими недугами страдают и достаточно молодые животные.
                Лишившись одного из органов чувств, животное, как правило, компенсирует недостаток. Так слепые собаки привыкают ориентироваться
                на нюх и память, а те, кто плохо слышат — отлично различают вибрацию и внимательно реагируют на любые изменения
                в окружающем пространстве. Соблюдение несложных правил техники безопасности и необходимость гулять с такой собакой
                только на поводке — вот, пожалуй, и все ограничения, накладываемые в подобной ситуации.
                """);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }
}
