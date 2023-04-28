package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.service.controllerService.UserCatControllerService;
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
class UserCatControllerTest {
    @Mock
    UserCatControllerService userCatRepository;

    @InjectMocks
    private UserCatController userCatController;

    private UserCat userCat = new UserCat();
    private Long id = 0L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {

        when(userCatRepository.getReferenceById(id)).thenReturn(userCat);

        ResponseEntity<UserCat> status = userCatController.getUserById(0);

        assertEquals(status.getBody(), userCat);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(userCatRepository.save(userCat)).thenReturn(id);
        ResponseEntity<Long> idNewUserCat = userCatController.addUser(userCat);
        assertEquals(idNewUserCat.getBody(), id);
    }

    @Test
    void shouldReturnRightObjectDelete() {

        when(userCatRepository.save(userCat)).thenReturn(id);
        when(userCatRepository.findById(id)).thenReturn(Optional.of(userCat));
        ResponseEntity<Long> idEditUserCat = userCatController.editUser(id, userCat);

    }

}