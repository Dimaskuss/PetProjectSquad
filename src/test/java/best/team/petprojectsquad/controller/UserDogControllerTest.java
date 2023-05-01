package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerServiceImpl.UserDogControllerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDogControllerTest {
    @Mock
    RepositoryService<UserDog> repositoryService;
    @InjectMocks
    private UserDogController userDogController;
    @MockBean
    private UserDogControllerServiceImpl userDogControllerService;

    private long id = 1;

    UserDog userDog = new UserDog(0, 1, "123");

    @Test
    void getUserById() {
        when(repositoryService.get(id)).thenReturn(Optional.ofNullable(userDog));

        ResponseEntity<UserDog> status = userDogController.getUserById(id);

        assertEquals(status.getBody(), userDog);
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