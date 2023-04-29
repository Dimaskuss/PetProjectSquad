/*
package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
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

    @InjectMocks
    private CatController catController;

    private UserCat userCat = new UserCat(123, "1");
    private Long id = 1L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {

        when(userCatRepository.getReferenceById(id)).thenReturn(userCat);

        ResponseEntity<UserCat> status = userCatController.getUserById(0);

        assertEquals(status.getBody(), userCat);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(userCatRepository.save(userCat, 123, 1)).thenReturn(id);
        ResponseEntity<Long> idNewUserCat = userCatController.addUser(id, 1, userCat);
        assertEquals(idNewUserCat, id);
    }

    @Test
    void shouldReturnRightObjectDelete() {

        when(userCatRepository.save(userCat, 123, 1)).thenReturn(id);
        when(userCatRepository.findById(id)).thenReturn(Optional.of(userCat));
        ResponseEntity<Long> idEditUserCat = userCatController.editUser(id, 1,userCat);

    }

}
*/
