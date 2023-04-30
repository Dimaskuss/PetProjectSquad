package best.team.petprojectsquad.service.controllerService;

import com.pengrad.telegrambot.request.SendMessage;

public interface VolunteerFunctionalControllerService {
    SendMessage sendRemark(long id);
}
