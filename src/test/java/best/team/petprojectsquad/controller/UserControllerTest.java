package best.team.petprojectsquad.controller;



import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks

    private UserController userController;

    private User user = new User (0L , null);
    private Long id = 0L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {

        when(userRepository.getReferenceById(id)).thenReturn(user);

        ResponseEntity<User> status = userController.getUserById(0);

        assertEquals(status.getBody(), user);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(userRepository.save(user)).thenReturn(user);
        ResponseEntity<Long> idNewCat = userController.addUser(user);
        assertEquals(idNewCat.getBody(), id);
    }

    @Test
    void shouldReturnRightObjectDelete() {

        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        ResponseEntity<Long> idEditCat = userController.editUser(id, user);
        assertEquals(idEditCat.getBody(), id);
    }


}