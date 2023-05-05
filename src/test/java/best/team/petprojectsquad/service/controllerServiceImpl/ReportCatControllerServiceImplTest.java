package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.ReportCatRepository;
import best.team.petprojectsquad.repository.UserCatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportCatControllerServiceImplTest {

    @Mock
    private ReportCatRepository repository;
    @Mock
    private UserCatRepository userCatRepository;

    @InjectMocks
    private ReportCatControllerServiceImpl service;

    long id = 1;
    ReportCat reportCat = new ReportCat();
    UserCat userCat = new UserCat();

    @Test
    void getReferenceById() {
        reportCat.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(reportCat));
        ReportCat actual = service.getReferenceById(id);
        assertEquals(reportCat, actual);
    }

    @Test
    void save() {
        userCat.setId(2);
        reportCat.setId(id);
        when(userCatRepository.getReferenceById(2L)).thenReturn(userCat);
        when(repository.save(reportCat)).thenReturn(reportCat);
        long actual = service.save(reportCat, 2);
        assertEquals(id, actual);
    }

    @Test
    void deleteById() {
        service.deleteById(id);
    }

    @Test
    void findAll() {
        List<ReportCat> expected = new ArrayList<>();
        expected.add(reportCat);
        when(repository.findAll()).thenReturn(expected);
        List<ReportCat> actual = service.findAll();
        assertEquals(expected,actual);
    }

    @Test
    void findById() {
        Optional<ReportCat> expected = Optional.of(reportCat);
        when(repository.findById(id)).thenReturn(Optional.of(reportCat));
        Optional<ReportCat> actual = service.findById(id);
        assertEquals(expected, actual);
    }
}