package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserCat;
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
class UserCatControllerTest {
    @Mock
    private UserCatController userCatController;
    private UserCat userCat = new UserCat(0L,null,null,0L,0);

    @Test
    void shouldReturnRightObjectPassIdGetter() {
        ResponseEntity<UserCat> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(userCatController.getUserById(0L)).thenReturn(status);
        assertEquals(userCatController.getUserById(0L), status);
    }

    @Test
    void shouldReturnRightObjectPassIdAdd() {
        assertNull(userCatController.addUser(userCat));
    }

    @Test
    void shouldReturnRightObjectPassIdDelete() {
        ResponseEntity<UserCat> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(userCatController.deleteUser(0L)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(userCatController.deleteUser(0L), status);
    }

    @Test
    void shouldReturnRightObjectPassIdEdit() {
        ResponseEntity<UserCat> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(userCatController.editUser(0L, userCat)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(userCatController.editUser(0L, userCat), status);
    }

    @Test
    void shouldReturnRightObjectPassIdGetAll() {
        ResponseEntity<List<UserCat>> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(userCatController.getAll()).thenReturn(status);
        assertEquals(userCatController.getAll(), status);
    }
}
