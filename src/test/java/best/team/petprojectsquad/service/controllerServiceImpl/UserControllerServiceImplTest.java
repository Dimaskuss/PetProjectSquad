package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerServiceImplTest {
    @Mock
    best.team.petprojectsquad.repository.UserRepository UserRepository;
    @InjectMocks
    UserControllerServiceImpl UserControllerService;
    long id = 0L;
    User User = new User(1L,"name");

    @Test
    void ShouldReturnRightReferenceById() {
        assertEquals(UserRepository.getReferenceById(id), UserControllerService.getReferenceById(id));
    }
    @Test
    void deleteById() {
        UserControllerService.deleteById(0L);
        assertNull(UserRepository.getReferenceById(0L));
    }

    @Test
    void findAll() {
        assertEquals(UserRepository.findAll(), UserControllerService.findAll());
    }

    @Test
    void findById() {
        assertEquals(UserControllerService.findById(-0L), Optional.empty());
    }
}