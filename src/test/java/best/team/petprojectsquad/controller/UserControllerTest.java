package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserRepository;
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
class UserControllerTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserController userController;
    long id = 123L;
    User user = new User(1, "User");

    @Test
    void shouldReturnUserById() {
        when(userRepository.getReferenceById(id)).thenReturn(user);
        ResponseEntity<User> status = userController.getUserById(id);
        assertEquals(status.getBody(), user);
    }

    @Test
    void addUser() {
//        when(userFeedBackControllerService.save(userFeedBack)).thenReturn(id);
//        ResponseEntity<Long> idNewUserCat = userFeedBackController.addUser(userFeedBack);
//        assertEquals(idNewUserCat.getBody(), id);


    }

    @Test
    void editUser() {
    }

    @Test
    void getAll() {
    }

    @Test
    void deleteUser() {
    }
}