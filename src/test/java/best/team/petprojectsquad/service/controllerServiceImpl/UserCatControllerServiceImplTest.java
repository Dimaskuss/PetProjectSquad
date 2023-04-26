package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.UserCatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class UserCatControllerServiceImplTest {
    @Mock
    UserCatRepository UserCatRepository;
    @InjectMocks
    UserCatControllerServiceImpl UserCatControllerService;
    long id = 0L;
    best.team.petprojectsquad.entity.UserCat UserCat = new UserCat(0,null,null,2018,8911);

    @Test
    void ShouldReturnRightReferenceById() {
        assertEquals(UserCatRepository.getReferenceById(id), UserCatControllerService.getReferenceById(id));
    }
    @Test
    void deleteById() {
        UserCatControllerService.deleteById(0L);
        assertNull(UserCatRepository.getReferenceById(0L));
    }

    @Test
    void findAll() {
        assertEquals(UserCatRepository.findAll(), UserCatControllerService.findAll());
    }

    @Test
    void findById() {
        assertEquals(UserCatControllerService.findById(-0L), Optional.empty());
    }
}