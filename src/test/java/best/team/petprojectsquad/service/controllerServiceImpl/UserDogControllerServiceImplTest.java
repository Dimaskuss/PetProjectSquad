package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.UserDog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserDogDogControllerServiceImplTest {
    @Mock
    best.team.petprojectsquad.repository.UserDogRepository UserDogRepository;
    @InjectMocks
    UserDogControllerServiceImpl UserDogControllerService;
    long id = 0L;
    best.team.petprojectsquad.entity.UserDog UserDog = new UserDog(4161L);

    @Test
    void ShouldReturnRightReferenceById() {
        assertEquals(UserDogRepository.getReferenceById(id), UserDogControllerService.getReferenceById(id));
    }
    @Test
    void deleteById() {
        UserDogControllerService.deleteById(0L);
        assertNull(UserDogRepository.getReferenceById(0L));
    }

    @Test
    void findAll() {
        assertEquals(UserDogRepository.findAll(), UserDogControllerService.findAll());
    }

    @Test
    void findById() {
        assertEquals(UserDogControllerService.findById(-0L), Optional.empty());
    }
}