package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.repository.DogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DogControllerTest{

    @Mock
    DogRepository dogRepository;

    @InjectMocks

    private DogController  dogController;

    private Dog dog = new Dog(0, null, null, 0, null,null);
    private Long id = 0L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {

        when(dogRepository.getReferenceById(id)).thenReturn(dog);

        ResponseEntity<Dog> status = dogController.getDogById(0);

        assertEquals(status.getBody(), dog);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(dogRepository.save(dog)).thenReturn(dog);
        ResponseEntity<Long> idNewCat = dogController.addDog(dog);
        assertEquals(idNewCat.getBody(),id);
    }

    @Test
    void shouldReturnRightObjectDelete() {

        when(dogRepository.save(dog)).thenReturn(dog);
        when(dogRepository.findById(id)).thenReturn(Optional.of(dog));
        ResponseEntity<Long> idEditCat = dogController.editDog(id, dog);
        assertEquals(idEditCat.getBody(),id);
    }


}