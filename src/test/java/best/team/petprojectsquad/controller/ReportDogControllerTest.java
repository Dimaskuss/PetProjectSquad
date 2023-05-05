package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerService.ReportDogControllerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ReportDogControllerTest {
    @Mock
    ReportDogControllerService reportDogControllerService;
    @InjectMocks
    private ReportDogController reportDogController;
    long id = 132L;
    ReportDog reportDog = new ReportDog("report", null, "1");

    @Test
    void shouldReturnReportById() {
        when(reportDogControllerService.getReferenceById(id)).thenReturn(reportDog);
        ResponseEntity<ReportDog> status = reportDogController.getReportById(id);
        assertEquals(status.getBody(), reportDog);
    }

    @Test
    void shouldReturnIdAddedReport() {
        when(reportDogControllerService.save(reportDog, id)).thenReturn(id);
        ResponseEntity<Long> idReportCat = reportDogController.addReport(id, reportDog);
        assertEquals(idReportCat.getBody(), id);
    }

    @Test
    void editReport() {
    }

    @Test
    void getAll() {
    }

    @Test
    void deleteReport() {
    }
}