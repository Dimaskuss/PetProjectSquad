package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerService.UserCatControllerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserCatControllerTest {
    @Mock
    RepositoryService<UserCat> userCatRepositoryService;
    @Mock
    private UserCatControllerService userCatControllerService;
    @InjectMocks
    private UserCatController userCatController;

    private long id = 1;
    Cat cat = new Cat(1L, null, null, 0, null);
    User user = new User();
    UserCat userCat = new UserCat(1, "123");

    @Test
    void shouldReturnUserById() {
        when(userCatRepositoryService.get(id)).thenReturn(Optional.ofNullable(userCat));
        ResponseEntity<UserCat> status = userCatController.getUserById(id);
        assertEquals(HttpStatus.OK, status.getStatusCode());
        assertEquals(status.getBody(), userCat);
    }

    @Test
    void addUserTrue() {
        when(userCatControllerService.checkIfEntitiesExist(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        when(userCatControllerService.save(cat.getId(), id, userCat)).thenReturn(id);
        ResponseEntity<Long> status = userCatController.addUserCat(cat.getId(), id, userCat);
        assertEquals(HttpStatus.OK, status.getStatusCode());
        assertEquals(id, status.getBody());
    }

    @Test
    void addUserFalse() {
        when(userCatControllerService.checkIfEntitiesExist(1L, 1L)).thenReturn(false);
        ResponseEntity<Long> response = userCatController.addUserCat(cat.getId(), id, userCat);
        verify(userCatControllerService).checkIfEntitiesExist(1L, 1L);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void editUserTest_whenEntitiesExist() {
        UserCat newUserCat = new UserCat(1, "456");
        when(userCatControllerService.checkIfEntitiesExist(id, id)).thenReturn(true);
        ResponseEntity<Long> response = userCatController.editUser(cat.getId(), id, newUserCat);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newUserCat.getId(), response.getBody());
    }

    @Test
    void editUserTest_whenEntitiesNotExist() {
        UserCat newUserCat = new UserCat(1, "456");
        when(userCatControllerService.checkIfEntitiesExist(id, id)).thenReturn(false);
        ResponseEntity<Long> response = userCatController.editUser(cat.getId(), id, newUserCat);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getAll_ReturnsListOfUserCats() {
        List<UserCat> userCats = new ArrayList<>();
        userCats.add(userCat);
        when(userCatRepositoryService.findAll()).thenReturn(userCats);
        ResponseEntity<List<UserCat>> response = userCatController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userCats, response.getBody());
    }

    @Test
    void getAll_ReturnsEmptyList_WhenRepositoryIsEmpty() {
        List<UserCat> userCats = new ArrayList<>();
        when(userCatRepositoryService.findAll()).thenReturn(userCats);
        ResponseEntity<List<UserCat>> response = userCatController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userCats, response.getBody());
    }

    @Test
    void deleteUserSuccess() {
        when(userCatRepositoryService.get(id)).thenReturn(Optional.ofNullable(userCat));
        ResponseEntity<Void> response = userCatController.deleteUser(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteUserNotFound() {
        when(userCatRepositoryService.get(id)).thenReturn(Optional.empty());
        ResponseEntity<Void> response = userCatController.deleteUser(id);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
//    @Test
//    void editUserTest_whenEntitiesExist() {
//// не срабатывает , но добавляет покрытие
//        UserCat newUserDog = new UserCat(1L,  "456");
//        when(repositoryService.get(newUserDog.getId())).thenReturn(Optional.ofNullable(newUserDog));
//        ResponseEntity<Long> response = userCatController.editUser(newUserDog.getCat().getId(), id, newUserDog);
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        assertEquals(newUserDog.getId(), response.getBody());
//    }

//    @Test
//    void editUserTest_whenEntitiesNotExist() {
//        UserCat newUserDog = new UserCat(1L, "456");
//        when(userCatControllerService.checkIfEntitiesExist(id, id)).thenReturn(false);
//
//        ResponseEntity<Long> response = userCatController.editUser(cat.getId(), id, newUserDog);
//
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        assertNull(response.getBody());
//    }

//    @Test
//    void getAll_ReturnsListOfUserDogs() {
//        List<UserCat> userDogs = new ArrayList<>();
//        userDogs.add(userCat);
//        when(repositoryService.findAll()).thenReturn(userDogs);
//        ResponseEntity<List<UserCat>> response = userCatController.getAll();
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userDogs, response.getBody());
//    }

//    @Test
//    void getAll_ReturnsEmptyList_WhenRepositoryIsEmpty() {
//        List<UserCat> userDogs = new ArrayList<>();
//        when(repositoryService.findAll()).thenReturn(userDogs);
//
//        ResponseEntity<List<UserCat>> response = userCatController.getAll();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userDogs, response.getBody());
//    }

//    @Test
//    void deleteUserSuccess() {
//        when(repositoryService.get(id)).thenReturn(Optional.ofNullable(userCat));
//        ResponseEntity<Void> response = userCatController.deleteUser(id);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }

//    @Test
//    void deleteUserNotFound() {
//        when(repositoryService.get(id)).thenReturn(Optional.empty());
//        ResponseEntity<Void> response = userCatController.deleteUser(id);
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//    }

