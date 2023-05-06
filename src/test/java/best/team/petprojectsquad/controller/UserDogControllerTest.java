package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerService.UserDogControllerService;
import best.team.petprojectsquad.service.controllerServiceImpl.UserDogControllerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDogControllerTest {
    @Mock
    RepositoryService<UserDog> userDogRepositoryService;
    @InjectMocks
    private UserDogController userDogController;
    @Mock
    private UserDogControllerService userDogControllerService;
    private long id = 1;
    Dog dog = new Dog(1L, null, null, 0, null);
    UserDog userDog = new UserDog(1, 1, "123");

    @Test
    void getUserById() {
        when(userDogRepositoryService.get(id)).thenReturn(Optional.ofNullable(userDog));
        ResponseEntity<UserDog> status = userDogController.getUserById(id);
        assertEquals(HttpStatus.OK, status.getStatusCode());
        assertEquals(status.getBody(), userDog);
    }

    @Test
    void addUserTrue() {
        when(userDogControllerService.checkIfEntitiesExist(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        when(userDogControllerService.save(userDog, id, dog.getId())).thenReturn(id);
        ResponseEntity<Long> status = userDogController.addUser(dog.getId(), id, userDog);
        assertEquals(HttpStatus.OK, status.getStatusCode());
        assertEquals(id, status.getBody());
    }

    @Test
    void addUserFalse() {
        when(userDogControllerService.checkIfEntitiesExist(1L, 1L)).thenReturn(false);
        ResponseEntity<Long> response = userDogController.addUser(dog.getId(), id, userDog);
        verify(userDogControllerService).checkIfEntitiesExist(1L, 1L);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }


    @Test
    void editUserTest_whenEntitiesExist() {
        UserDog newUserDog = new UserDog(1, 1, "456");
        when(userDogControllerService.checkIfEntitiesExist(id, id)).thenReturn(true);
        ResponseEntity<Long> response = userDogController.editUser(dog.getId(), id, newUserDog);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newUserDog.getId(), response.getBody());
    }

    @Test
    void editUserTest_whenEntitiesNotExist() {
        UserDog newUserDog = new UserDog(1, 1, "456");
        when(userDogControllerService.checkIfEntitiesExist(id, id)).thenReturn(false);
        ResponseEntity<Long> response = userDogController.editUser(dog.getId(), id, newUserDog);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getAll_ReturnsListOfUserDogs() {
        List<UserDog> userDogs = new ArrayList<>();
        userDogs.add(userDog);
        when(userDogRepositoryService.findAll()).thenReturn(userDogs);
        ResponseEntity<List<UserDog>> response = userDogController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDogs, response.getBody());
    }

    @Test
    void getAll_ReturnsEmptyList_WhenRepositoryIsEmpty() {
        List<UserDog> userDogs = new ArrayList<>();
        when(userDogRepositoryService.findAll()).thenReturn(userDogs);
        ResponseEntity<List<UserDog>> response = userDogController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDogs, response.getBody());
    }

    @Test
    void deleteUserSuccess() {
        when(userDogRepositoryService.get(id)).thenReturn(Optional.ofNullable(userDog));
        ResponseEntity<Void> response = userDogController.deleteUser(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteUserNotFound() {
        when(userDogRepositoryService.get(id)).thenReturn(Optional.empty());
        ResponseEntity<Void> response = userDogController.deleteUser(id);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
