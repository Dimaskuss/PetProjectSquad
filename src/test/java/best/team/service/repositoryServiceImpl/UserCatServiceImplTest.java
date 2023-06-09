package best.team.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserCatServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class UserCatServiceImplTest {

    @Mock
    UserCatRepository repository;

    @InjectMocks
    UserCatServiceImpl service;
    long id = 0L;
    UserCat userCat = new UserCat(0, null, 123, "Str");

    @Test
    void ShouldReturnRightReferenceById() {
        assertEquals(repository.findById(id), service.get(id));
    }
    @Test
    void deleteById() {
        service.delete(0L);
        assertNull(repository.getReferenceById(0L));
    }

    @Test
    void findAll() {
        assertEquals(repository.findAll(), service.findAll());
    }

    @Test
    void findById() {
        assertEquals(service.get(-0L), Optional.empty());
    }

    @Test
    void findAllUsersOnTrialPeriod() {

        List<UserCat> usersOnTrialExpected = repository.findAll().stream().filter(userCat -> userCat.getTrialPeriod()>0).toList();

        List<UserCat> usersOnTrialActual = repository.findAllByTrialPeriodIsGreaterThan(0);

        assertEquals(usersOnTrialExpected, usersOnTrialActual);
    }
}