package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserDogRepository;
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
class UserDogControllerTest {

    @Mock
    UserDogRepository userDogRepository;

    @InjectMocks

    private UserDogController userDogController;

    private UserDog userDog = new UserDog(0L);
    private Long id = 0L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {

        when(userDogRepository.getReferenceById(id)).thenReturn(userDog);

        ResponseEntity<UserDog> status = userDogController.getUserById(0);

        assertEquals(status.getBody(), userDog);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(userDogRepository.save(userDog)).thenReturn(userDog);
        ResponseEntity<Long> idNewCat = userDogController.addUser(userDog);
        assertEquals(idNewCat.getBody(), id);
    }

    @Test
    void shouldReturnRightObjectDelete() {

        when(userDogRepository.save(userDog)).thenReturn(userDog);
        when(userDogRepository.findById(id)).thenReturn(Optional.of(userDog));
        ResponseEntity<Long> idEditCat = userDogController.editUser(id, userDog);
        assertEquals(idEditCat.getBody(), id);
    }


}
