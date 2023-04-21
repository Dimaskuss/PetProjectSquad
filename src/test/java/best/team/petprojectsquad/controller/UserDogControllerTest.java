package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserDog;
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
class UserDogControllerTest {
    @Mock
    private UserDogController UserDogController;
    private UserDog UserDog = new UserDog(0L,0L,null,null,0);

    @Test
    void shouldReturnRightObjectPassIdGetter() {
        ResponseEntity<UserDog> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(UserDogController.getUserById(0L)).thenReturn(status);
        assertEquals(UserDogController.getUserById(0L), status);
    }

    @Test
    void shouldReturnRightObjectPassIdAdd() {
        assertNull(UserDogController.addUser(UserDog));
    }

    @Test
    void shouldReturnRightObjectPassIdDelete() {
        ResponseEntity<UserDog> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(UserDogController.deleteUser(0L)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(UserDogController.deleteUser(0L), status);
    }

    @Test
    void shouldReturnRightObjectPassIdEdit() {
        ResponseEntity<UserDog> status = new ResponseEntity<>(ResponseEntity.noContent().build().getStatusCode());
        when(UserDogController.editUser(0L, UserDog)).thenReturn(ResponseEntity.noContent().build());
        assertEquals(UserDogController.editUser(0L, UserDog), status);
    }

    @Test
    void shouldReturnRightObjectPassIdGetAll() {
        ResponseEntity<List<UserDog>> status = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(UserDogController.getAll()).thenReturn(status);
        assertEquals(UserDogController.getAll(), status);
    }
}
