/*
package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.service.controllerService.UserDogControllerService;
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
class UserDogControllerTest {
    @Mock
    UserDogControllerService userDogRepository;

    @InjectMocks
    private UserDogController userDogController;

    private UserDog userDog = new UserDog(0, 0, 0);
    private Long id = 0L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {

        when(userDogRepository.getReferenceById(id)).thenReturn(userDog);

        ResponseEntity<UserDog> status = userDogController.getUserById(0);

        assertEquals(status.getBody(), userDog);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(userDogRepository.save(userDog)).thenReturn(id);
        ResponseEntity<Long> idNewUserDog = userDogController.addUser(userDog);
        assertEquals(idNewUserDog.getBody(), id);
    }

    @Test
    void shouldReturnRightObjectDelete() {

        when(userDogRepository.save(userDog)).thenReturn(id);
        when(userDogRepository.findById(id)).thenReturn(Optional.of(userDog));
        ResponseEntity<Long> idEditUserDog = userDogController.editUser(id, userDog);

    }

}*/
