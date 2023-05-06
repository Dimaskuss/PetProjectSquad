package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private RepositoryService<User> userRepositoryService;
    @InjectMocks
    private UserController userController;

    long id = 123L;
    User user = new User(1, "User");

    @Test
    void shouldReturnUserById() {
        when(userRepositoryService.get(id)).thenReturn(Optional.of(user));
        ResponseEntity<User> status = userController.getUserById(id);
        assertEquals(status.getBody(), user);
    }

    @Test
    void addUser() {
        when(userRepositoryService.save(user)).thenReturn(user.getId());
        ResponseEntity<Long> response = userController.addUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user.getId(), response.getBody());
    }

    @Test
    void shouldReturnIdEditedReport() {
        user.setId(123L);
        when(userRepositoryService.get(id)).thenReturn(Optional.ofNullable(user));
        ResponseEntity<Long> idReportCat = userController.editUser(id , user);
        assertEquals(idReportCat.getBody(), id);
    }
//    void editUserTest_whenEntitiesExist() {
//        when(userRepositoryService.get(id).isEmpty()).thenReturn(true);
//        ResponseEntity<Long> response = userController.editUser(id, user);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(user.getId(), response.getBody());
//    }
//
//    @Test
//    void editUserTest_whenEntitiesNotExist() {
//        when(userRepositoryService.get(id).isEmpty()).thenReturn(true);
//        ResponseEntity<Long> response = userController.editUser(id, user);
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        assertNull(response.getBody());
//    }

    @Test
    void getAll() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepositoryService.findAll()).thenReturn(userList);
        ResponseEntity<List<User>> actual = userController.getAll();
        assertEquals(Objects.requireNonNull(actual.getBody()).size(), userList.size());
    }

    @Test
    void deleteUser() {
        when(userRepositoryService.get(id)).thenReturn(Optional.ofNullable(user));
        ResponseEntity<Void> response = userController.deleteUser(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}