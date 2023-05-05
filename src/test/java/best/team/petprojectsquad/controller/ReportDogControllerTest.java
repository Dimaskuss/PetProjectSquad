package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.service.RepositoryService;
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
    RepositoryService<ReportDog> repositoryReportDog;
    @InjectMocks
    private ReportDogController reportDogController;
    long id = 132L;
    ReportDog reportDog = new ReportDog("report", null, "1");

    @Test
    void shouldReturnReportById() {
        when(repositoryReportDog.get(id)).thenReturn(Optional.ofNullable(reportDog));
        ResponseEntity<ReportDog> status = reportDogController.getReportById(id);
        assertEquals(status.getBody(), reportDog);
    }

    @Test
    void shouldReturnIdAddedReport() {
        when(repositoryReportDog.save(reportDog)).thenReturn(id);
        ResponseEntity<Long> idReportCat = reportDogController.addReport(reportDog);
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