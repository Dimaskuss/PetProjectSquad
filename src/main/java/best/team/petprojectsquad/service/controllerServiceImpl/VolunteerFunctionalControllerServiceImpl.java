package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.controllerService.VolunteerFunctionalControllerService;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VolunteerFunctionalControllerServiceImpl implements VolunteerFunctionalControllerService {
    private final UserRepository userRepository;

    @Override
    public SendMessage sendRemark(long id) {
        long chatId = userRepository.getReferenceById(id).getChatId();
        return new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. Пожалуйста, " +
                "подойди ответственнее к этому занятию. В противном случае волонтеры приюта будут обязаны самолично " +
                "проверять условия содержания животного");
    }
}
