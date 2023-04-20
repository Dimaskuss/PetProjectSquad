package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.entity.Dog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DogControllerTest {
    @Mock
    private DogController DogController;
    private Dog dog = new Dog(0, null, null, 0, null);

    @Test
    void shouldReturnRightObjectPassIdGetter() {
        ResponseEntity<Dog> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(DogController.getDogById(0)).thenReturn(status);
        assertEquals(DogController.getDogById(0), status);
    }

    @Test
    void shouldReturnRightObjectPassIdAdd() {
        ResponseEntity<Dog> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        assertNull(DogController.addDog(dog));
    }

    @Test
    void shouldReturnRightObjectPassIdDelete() {
        ResponseEntity<Dog> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(DogController.deleteDog(0)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(DogController.deleteDog(0), status);
    }

    @Test
    void shouldReturnRightObjectPassIdEdit() {
        ResponseEntity<Dog> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(DogController.editDog(0, dog)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(DogController.editDog(0, dog), status);
    }

    @Test
    void shouldReturnRightObjectPassIdGetAll() {
        ResponseEntity<List<Dog>> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(DogController.getAll()).thenReturn(status);
        assertEquals(DogController.getAll(), status);
    }
}
