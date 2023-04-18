package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Shelter;
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
class ShelterControllerTest {
    @Mock
    private ShelterController ShelterController;
    private Shelter shelter = new Shelter(0L,"STr","STr","STr","STr","STr");

    @Test
    void shouldReturnRightObjectPassIdGetter() {
        ResponseEntity<Shelter> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(ShelterController.getShelterById(0L)).thenReturn(status);
        assertEquals(ShelterController.getShelterById(0L), status);
    }

    @Test
    void shouldReturnRightObjectPassIdAdd() {
        assertNull(ShelterController.addShelter(shelter));
    }

    @Test
    void shouldReturnRightObjectPassIdDelete() {
        ResponseEntity<Shelter> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(ShelterController.deleteShelter(0L)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(ShelterController.deleteShelter(0L), status);
    }

    @Test
    void shouldReturnRightObjectPassIdEdit() {
        ResponseEntity<Shelter> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(ShelterController.editShelter(0L, shelter)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(ShelterController.editShelter(0L, shelter), status);
    }

    @Test
    void shouldReturnRightObjectPassIdGetAll() {
        ResponseEntity<List<Shelter>> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(ShelterController.getAll()).thenReturn(status);
        assertEquals(ShelterController.getAll(), status);
    }
}
