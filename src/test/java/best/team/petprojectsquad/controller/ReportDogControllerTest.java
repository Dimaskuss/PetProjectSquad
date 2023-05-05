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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    void shouldReturnIdEditedReport() {
//        todo добить тест
    }

    @Test
    void getAll() {
        List<ReportDog> list = new ArrayList<>();
        list.add(reportDog);
        when(reportDogControllerService.findAll()).thenReturn(list);
        ResponseEntity<List<ReportDog>> listReportCat = reportDogController.getAll();
        assertEquals(Objects.requireNonNull(listReportCat.getBody()).size(), list.size());
    }

    @Test
    void shouldDeleteReport() {
        ResponseEntity<Void> actual = reportDogController.deleteReport(id);;
        assertNull(actual.getBody());
    }
}