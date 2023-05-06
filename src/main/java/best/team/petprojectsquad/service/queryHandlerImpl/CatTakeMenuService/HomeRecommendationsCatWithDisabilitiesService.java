package best.team.petprojectsquad.service.queryHandlerImpl.CatTakeMenuService;

import best.team.petprojectsquad.service.QueryHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HomeRecommendationsCatWithDisabilitiesService implements QueryHandlerService {
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
                Взять из приюта котика с ограниченными возможностями – это серьезное решение.
                Однако пусть это вас не отпугнет, ведь такие животные нуждаются в любви и заботе чуть больше остальных.
                Глухие кошки обычно ведут себя подобно слышащим сородичам. Они не слышат, но при этом прекрасно улавливают вибрации и колебания.
                Однако учитывайте, что ваше бесшумное появление в комнате напугает животное. Поэтому чтобы кошка не испугалась от вашего приближения,
                начинайте сильнее топать издалека. Не заходите к ней со спины – старайтесь, чтобы перед приближением вы попадали в поле зрения питомицы.
                Так же ведите себя, если намерены погладить. Кошка должна увидеть руку, которая приближается к ней и только потом ощутить прикосновение.
                Слепые кошки компенсируют отсутствие зрения слухом и обонянием. Не подкрадывайтесь к кошке сзади, не кричите, избегайте резких звуков,
                чтобы не пугать животное. Больше разговаривайте с питомцем, ласково зовите по имени, прежде чем подойти,
                давайте понюхать руку до того, как погладить.
                Недостаток одной лапы кошки компенсируют довольно быстро, научившись ходить и даже бегать на трех ногах.
                Однако, если вы решились взять животное с парализованными задними лапами, побеспокойтесь о том,
                чтобы у вам дома не было высоких порогов и лестниц. С таким животным надо будет чаще посещать ветеринара,
                уделять котику больше внимания и заботы. Будьте уверены, питомец ответит вам взаимностью.
                """);
        requestArrayList.add(sendMessage);

        return requestArrayList;
    }
}
