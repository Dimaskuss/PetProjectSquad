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
    best.team.petprojectsquad.repository.UserDogRepository userDogRepository;
    @InjectMocks
    UserDogControllerServiceImpl userDogControllerService;
    long id = 1L;
    best.team.petprojectsquad.entity.UserDog UserDog = new UserDog(4161L);

    @Test
    void ShouldReturnRightReferenceById() {
        assertEquals(userDogRepository.getReferenceById(id), userDogControllerService.getReferenceById(id));
    }
    @Test
    void deleteById() {
        userDogControllerService.deleteById(0L);
        assertNull(userDogRepository.getReferenceById(0L));
    }

    @Test
    void findAll() {
        assertEquals(userDogRepository.findAll(), userDogControllerService.findAll());
    }

    @Test
    void findById() {
        assertEquals(userDogControllerService.findById(-0L), Optional.empty());
    }
}