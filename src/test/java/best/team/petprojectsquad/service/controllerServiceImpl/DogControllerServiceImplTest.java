package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.repository.DogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DogControllerServiceImplTest {
    @Mock
    DogRepository dogRepository;

    @InjectMocks
    DogControllerServiceImpl dogControllerService;
    long id = 0L;
    Dog dog = new Dog(0,null,null,2018,null);

    @Test
    void ShouldReturnRightReferenceById() {
        assertEquals(dogRepository.findById(id), dogControllerService.findById(id));
    }
    @Test
    void deleteById() {
        dogControllerService.deleteById(0L);
        assertNull(dogRepository.getReferenceById(0L));
    }

    @Test
    void findAll() {
        assertEquals(dogRepository.findAll(), dogControllerService.findAll());
    }

    @Test
    void findById() {
        assertEquals(dogControllerService.findById(-0L), Optional.empty());
    }
}