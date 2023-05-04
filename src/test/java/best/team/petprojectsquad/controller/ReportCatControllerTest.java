package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ReportCatControllerTest {
    @Mock
    RepositoryService<ReportCat> repositoryReportCat;
    @InjectMocks
    private ReportCatController reportCatController;
    long id = 132L;
    ReportCat reportCat = new ReportCat("report", null, "1");

    @Test
    void shouldReturnReportById() {
        when(repositoryReportCat.get(id)).thenReturn(Optional.ofNullable(reportCat));
        ResponseEntity<ReportCat> status = reportCatController.getReportById(id);
        assertEquals(status.getBody(), reportCat);
    }

    @Test
    void shouldReturnIdAddedReport() {
        when(repositoryReportCat.save(reportCat)).thenReturn(id);
        ResponseEntity<Long> idReportCat = reportCatController.addReport(reportCat);
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