package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerService.ReportCatControllerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportCatControllerTest {
    @Mock
    ReportCatControllerService reportCatControllerService;
    @InjectMocks
    private ReportCatController reportCatController;
    long id = 0L;
    ReportCat reportCat = new ReportCat("report", null, "1");
    UserCat userCat = new UserCat();

    @Test
    void shouldReturnReportById() {
        when(reportCatControllerService.getReferenceById(id)).thenReturn(reportCat);
        ResponseEntity<ReportCat> status = reportCatController.getReportById(id);
        assertEquals(status.getBody(), reportCat);
    }

    @Test
    void shouldReturnIdAddedReport() {
        when(reportCatControllerService.save(reportCat, id)).thenReturn(id);
        ResponseEntity<Long> idReportCat = reportCatController.addReport(id, reportCat);
        assertEquals(idReportCat.getBody(), id);
    }

    @Test
    void shouldReturnIdEditedReport() {
        userCat.setId(1);
        reportCat.setUserCat(userCat);
        when(reportCatControllerService.getReferenceById(id)).thenReturn(reportCat);
        ResponseEntity<Long> idReportCat = reportCatController.editReport(id , reportCat);
        assertEquals(idReportCat.getBody(), id);
    }

    @Test
    void shouldReturnListReports() {
        List<ReportCat> list = new ArrayList<>();
        list.add(reportCat);
        when(reportCatControllerService.findAll()).thenReturn(list);
        ResponseEntity<List<ReportCat>> listReportCat = reportCatController.getAll();
        assertEquals(Objects.requireNonNull(listReportCat.getBody()).size(), list.size());
    }

    @Test
    void shouldDeleteReport() {
        ResponseEntity<Void> actual = reportCatController.deleteReport(id);;
        assertNull(actual.getBody());
    }
}