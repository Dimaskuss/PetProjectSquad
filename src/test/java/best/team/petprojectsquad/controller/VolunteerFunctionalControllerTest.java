package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.controller.VolunteerFunctionalController;
import best.team.petprojectsquad.entity.ShelterTypeOfTable;
import best.team.petprojectsquad.entity.StatusOfDecision;
import best.team.petprojectsquad.service.controllerService.VolunteerFunctionalControllerService;
import com.pengrad.telegrambot.response.SendResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VolunteerFunctionalControllerTest {
    @Mock
    private VolunteerFunctionalControllerService volunteerService;


    private VolunteerFunctionalController volunteerController;

    @BeforeEach
    void setUp() {
        volunteerController = new VolunteerFunctionalController(volunteerService);
    }

    @Test
    void sendUserRemarkMessage_ShouldReturnOkResponse() {
        long userId = 1L;
        SendResponse sendResponse = mock(SendResponse.class);
        when(volunteerService.sendRemark(userId)).thenReturn(sendResponse);

        ResponseEntity<SendResponse> responseEntity = volunteerController.sendUserRemarkMessage(userId);

        verify(volunteerService, times(1)).sendRemark(userId);
        verifyNoMoreInteractions(volunteerService);
        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == sendResponse;
    }

    @Test
    void sendMessageToUserAboutDecision_ShouldReturnOkResponse() {
        long userId = 1L;
        String status = "SUCCESSFULLY_PASSED";
        String type = "CAT";
        StatusOfDecision enumStatus = StatusOfDecision.SUCCESSFULLY_PASSED;
        ShelterTypeOfTable enumType = ShelterTypeOfTable.CAT_SHELTER;
        SendResponse sendResponse = mock(SendResponse.class);
        when(volunteerService.getEnumTypeOfDecision(status)).thenReturn(enumStatus);
        when(volunteerService.getEnumTypeOfShelter(type)).thenReturn(enumType);
        when(volunteerService.sendDecision(userId, enumStatus, enumType)).thenReturn(sendResponse);

        ResponseEntity<SendResponse> responseEntity = volunteerController.sendMessageToUserAboutDecision(userId, status, type);

        verify(volunteerService, times(1)).getEnumTypeOfDecision(status);
        verify(volunteerService, times(1)).getEnumTypeOfShelter(type);
        verify(volunteerService, times(1)).sendDecision(userId, enumStatus, enumType);
        verifyNoMoreInteractions(volunteerService);
        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == sendResponse;
    }

    @Test
    void sendMessageToUserAboutDecision_ShouldReturnBadRequestResponse() {
        long userId = 1L;
        String status = "SUCCESSFULLY_PASSED";
        String type = "BIRD";
        StatusOfDecision enumStatus = StatusOfDecision.SUCCESSFULLY_PASSED;
        ShelterTypeOfTable enumType = null;
        when(volunteerService.getEnumTypeOfDecision(status)).thenReturn(enumStatus);
        when(volunteerService.getEnumTypeOfShelter(type)).thenReturn(enumType);

        ResponseEntity<SendResponse> responseEntity = volunteerController.sendMessageToUserAboutDecision(userId, status, type);

        verify(volunteerService, times(1)).getEnumTypeOfDecision(status);
        verify(volunteerService, times(1)).getEnumTypeOfShelter(type);
        verifyNoMoreInteractions(volunteerService);
        assert responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST;
        assert responseEntity.getBody() == null;

    }

    @Test
    void getListOfDogOrCatUsers_ShouldReturnListOfUsers() {

        List<String> expectedList = Arrays.asList("User1", "User2", "User3");
        when(volunteerService.getListOfCatAndDogUsers()).thenReturn(expectedList);

        ResponseEntity<List<String>> response = volunteerController.getListOfDogOrCatUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedList, response.getBody());
    }


    @Test
    void getListOfReports_ShouldReturnListOfReports() {

        List<String> expectedList = Arrays.asList("Report1", "Report2", "Report3");
        Mockito.when(volunteerService.getListOfReportUsers()).thenReturn(expectedList);

        ResponseEntity<List<String>> response = volunteerController.gelListOfReports();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedList, response.getBody());
    }




}
