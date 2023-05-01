package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DogControllerTest {
    @Mock
    RepositoryService<Dog> dogRepository;

    @InjectMocks
    private DogController DogController;

    private Dog dog = new Dog(0, null, null, 0, null);
    private Long id = 0L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {
        when(dogRepository.get(id)).thenReturn(Optional.ofNullable(dog));

        ResponseEntity<Dog> status = DogController.getDogById(0);

        assertEquals(status.getBody(), dog);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(dogRepository.save(dog)).thenReturn(id);
        ResponseEntity<Long> idNewDog = DogController.addDog(dog);
        assertEquals(idNewDog.getBody(), id);
    }

    @Test
    void shouldReturnRightObjectDelete() {

        when(dogRepository.save(dog)).thenReturn(id);
        when(dogRepository.get(id)).thenReturn(Optional.of(dog));
        ResponseEntity<Long> idEditDog = DogController.editDog(id, dog);

    }
}