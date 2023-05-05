package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.ReportDogRepository;
import best.team.petprojectsquad.repository.UserDogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportDogControllerServiceImplTest {

    @Mock
    private ReportDogRepository repository;
    @Mock
    private UserDogRepository userDogRepository;

    @InjectMocks
    private ReportDogControllerServiceImpl service;

    long id = 1;
    ReportDog reportDog = new ReportDog();
    UserDog userDog = new UserDog();

    @Test
    void getReferenceById() {
        reportDog.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(reportDog));
        ReportDog actual = service.getReferenceById(id);
        assertEquals(reportDog, actual);
    }

    @Test
    void save() {
        userDog.setId(2);
        reportDog.setId(id);
        when(userDogRepository.findById(2L)).thenReturn(Optional.of(userDog));
        when(repository.save(reportDog)).thenReturn(reportDog);
        long actual = service.save(reportDog, 2);
        assertEquals(id, actual);
    }

    @Test
    void deleteById() {
        service.deleteById(id);
    }

    @Test
    void findAll() {
        List<ReportDog> expected = new ArrayList<>();
        expected.add(reportDog);
        when(repository.findAll()).thenReturn(expected);
        List<ReportDog> actual = service.findAll();
        assertEquals(expected,actual);
    }

    @Test
    void findById() {
        Optional<ReportDog> expected = Optional.of(reportDog);
        when(repository.findById(id)).thenReturn(Optional.of(reportDog));
        Optional<ReportDog> actual = service.findById(id);
        assertEquals(expected, actual);
    }
}