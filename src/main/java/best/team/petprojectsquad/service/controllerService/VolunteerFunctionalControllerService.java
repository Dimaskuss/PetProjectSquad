package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.ShelterTypeOfTable;
import best.team.petprojectsquad.entity.StatusOfDecision;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

public interface VolunteerFunctionalControllerService {
    SendResponse sendRemark(long id);

    SendResponse sendDecision(long id, StatusOfDecision status, ShelterTypeOfTable type);

    List<String> getListOfCatAndDogUsers();

    StatusOfDecision getEnumTypeOfDecision(String decision);

    ShelterTypeOfTable getEnumTypeOfShelter(String shelter);

    List<String> getListOfReportUsers();

    SendResponse acceptOrRejectReportByUserId(long idOfReport, boolean reportAccepted, ShelterTypeOfTable typeOfShelter);
}
