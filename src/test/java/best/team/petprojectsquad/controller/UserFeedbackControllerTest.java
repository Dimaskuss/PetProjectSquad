package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.service.controllerService.UserFeedBackControllerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;


    @ExtendWith(MockitoExtension.class)
    class UserFeedbackControllerTest {
        @Mock
        UserFeedBackControllerService userFeedBackControllerService;

        @InjectMocks
        private UserFeedBackController userFeedBackController;

        private UserFeedBack userFeedBack = new UserFeedBack("+79117076105", 123, "Dog");
        private final Long id = 0L;

        @Test
        void shouldReturnRightObjectPassIdGetter() {
            when(userFeedBackControllerService.getReferenceById(id)).thenReturn(userFeedBack);

            ResponseEntity<UserFeedBack> status = userFeedBackController.getUserById(id);

            assertEquals(status.getBody(), userFeedBack);
        }

        @Test
        void shouldReturnRightObjectPassAdd() {

            when(userFeedBackControllerService.save(userFeedBack)).thenReturn(id);
            ResponseEntity<Long> idNewUserCat = userFeedBackController.addUser(userFeedBack);
            assertEquals(idNewUserCat.getBody(), id);
        }

        @Test
        void shouldReturnRightObjectDelete() {

            when(userFeedBackControllerService.save(userFeedBack)).thenReturn(id);
            when(userFeedBackControllerService.findById(id)).thenReturn(Optional.of(userFeedBack));
            ResponseEntity<Long> idEditCat = userFeedBackController.editUser(id, userFeedBack);
            assertEquals(idEditCat.getBody(),id);
        }
        @Test
        void shouldReturnRightListOfObjects(){
            List<UserFeedBack> list = new ArrayList<UserFeedBack>();
            list.add(userFeedBack);
            when( userFeedBackControllerService.findAll()).thenReturn(list);
            ResponseEntity<List<UserFeedBack>> userFeedBackResponseEntity=userFeedBackController.getAll();
            assertEquals(userFeedBackResponseEntity.getBody().size(),list.size());

        }
        @Test
        void shouldNotDeleteWhenObjectNull(){

            when(userFeedBackControllerService.findById(id)).thenReturn(isNull());
            Optional<UserFeedBack> responseEntity = userFeedBackControllerService.findById(id);
            assertNull(responseEntity);
        }

    }


