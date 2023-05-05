package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.service.controllerService.VolunteerFunctionalControllerService;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VolunteerFunctionalControllerTest {
    @Mock
    private VolunteerFunctionalControllerService volunteerFunctionalControllerService;

    @InjectMocks
    private VolunteerFunctionalController volunteerFunctionalController;
    private long chatId = 123L;

    @Test
    void sendUserRemarkMessage() {
        SendMessage sendMessage = new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь " +
                "отчет не так подробно, как необходимо. Пожалуйста, подойди ответственнее к этому занятию. " +
                "В противном случае волонтеры приюта будут обязаны самолично " +
                "проверять условия содержания животного");
    }
}