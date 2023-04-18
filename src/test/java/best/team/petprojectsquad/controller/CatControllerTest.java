package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatControllerTest{
    @Mock
    private CatController catController;
    private Cat cat = new Cat(0, null, null, 0, null);
    private Long id = 0L;
    @Test
    void shouldReturnRightObjectPassIdGetter() {
        ResponseEntity<Cat> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(catController.getCatById(0)).thenReturn(status);
        assertEquals(catController.getCatById(0), status);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {
        ResponseEntity<Cat> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        assertNull(catController.addCat(cat));
    }

    @Test
    void shouldReturnRightObjectDelete() {
        ResponseEntity<Cat> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(catController.deleteCat(0)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(catController.deleteCat(0), status);
    }

    @Test
    void shouldReturnRightObjectPassIdEdit() {
        ResponseEntity<Cat> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(catController.editCat(0, cat)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(catController.editCat(0, cat), status);
    }

    @Test
    void shouldReturnRightObjectPassIdGetAll() {
        ResponseEntity<List<Cat>> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(catController.getAll()).thenReturn(status);
        assertEquals(catController.getAll(), status);
    }
}
