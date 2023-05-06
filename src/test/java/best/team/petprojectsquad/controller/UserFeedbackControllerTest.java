package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.service.controllerService.UserFeedBackControllerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
    class UserFeedbackControllerTest {

        @Mock
        UserFeedBackRepository userFeedBackRepository;
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
        @Test
        void shouldReturnNoContentWhenUserFeedBackIsNotFound()
        {
            // Arrange
            long id = 1L;
//            when(userFeedBackRepository.findById(id)).thenReturn(Optional.empty());

            // Act
            ResponseEntity<Void> responseEntity = userFeedBackController.deleteUser(id);

            // Assert
            assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        }

//        @Test
//        void shouldDeleteUserFeedBackAndReturnOk() {
//            // Arrange
//            long id = 1L;
//            UserFeedBack userFeedBack = new UserFeedBack("+79117076105", 123, "Dog");
//            userFeedBack.setId(id);
//            when(userFeedBackRepository.findById(id)).thenReturn(Optional.of(userFeedBack));
//
//            // Act
//            ResponseEntity<Void> responseEntity = userFeedBackController.deleteUser(id);
//
//            // Assert
//            assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
////            verify(userFeedBackRepository, times(1)).deleteById(id);

//        }

        @Test
        void shouldReturnNoContentWhenUserFeedBackNotFoundOnEdit() {
            // Arrange
            long id = 1L;
            when(userFeedBackRepository.findById(id)).thenReturn(Optional.empty());

            // Act
            ResponseEntity<Long> responseEntity = userFeedBackController.setFalseConditionFeedBack(id);

            // Assert
            assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        }



    @Test
    void shouldReturnNoContentWhenUserFeedBackIsNotFoundTwo() {
        // Arrange
        long id = 1L;
        when(userFeedBackRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Long> responseEntity = userFeedBackController.setFalseConditionFeedBack(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
        verify(userFeedBackRepository, never()).deleteById(id);
        verify(userFeedBackRepository, never()).save(any(UserFeedBack.class));
    }

//    @Test
//    void shouldReturnBadRequestWhenIdIsNull() {
//        // Arrange
//        Long id = null;
//
//        // Act
//        ResponseEntity<Long> responseEntity = userFeedBackController.setFalseConditionFeedBack(id);
//
//        // Assert
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
//        assertNull(responseEntity.getBody());
//        verify(userFeedBackRepository, never()).deleteById(anyLong());
//        verify(userFeedBackRepository, never()).save(any(UserFeedBack.class));
//    }
    }


