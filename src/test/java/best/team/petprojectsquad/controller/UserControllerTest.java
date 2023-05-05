package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private RepositoryService repositoryService;
    @InjectMocks
    private UserController userController;

    long id = 123L;
    User user = new User(1, "User");

    @Test
    void shouldReturnUserById() {
        when(repositoryService.get(id)).thenReturn(Optional.of(user));
        ResponseEntity<User> status = userController.getUserById(id);
        assertEquals(status.getBody(), user);
    }

    @Test
    void addUser() {
        when(repositoryService.save(user)).thenReturn(user.getId());
        ResponseEntity<Long> response = userController.addUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user.getId(), response.getBody());
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