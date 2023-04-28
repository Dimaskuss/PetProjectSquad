package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatControllerServiceImplTest {
    @Mock
    CatRepository CatRepository;

    @InjectMocks
    CatControllerServiceImpl CatControllerService;
    long id = 0L;
    Cat Cat = new Cat(0,null,null,2018,null);

    @Test
    void ShouldReturnRightReferenceById() {
        assertEquals(CatRepository.findById(id).get(), CatControllerService.findById(id).get());
    }
    @Test
    void deleteById() {
        CatControllerService.deleteById(0L);
        assertNull(CatRepository.getReferenceById(0L));
    }

    @Test
    void findAll() {
        assertEquals(CatRepository.findAll(), CatControllerService.findAll());
    }

    @Test
    void findById() {
        assertEquals(CatControllerService.findById(-0L), Optional.empty());
    }
}