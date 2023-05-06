package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.SuperUserVolunteer;
import best.team.petprojectsquad.entity.UserFeedBack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


    @ExtendWith(MockitoExtension.class)
    class UserFeedbackControllerServiceImplTest {
        @Mock
        best.team.petprojectsquad.repository.UserFeedBackRepository UserRepository;
        @InjectMocks
        UserFeedBackControllerServiceImpl UserControllerService;
        long id = 0L;
        best.team.petprojectsquad.entity. UserFeedBack  userFeedBack = new UserFeedBack(1L,null, 1, null,true);

        @Test
        void ShouldReturnRightReferenceById() {
            assertEquals(UserRepository.getReferenceById(id), UserControllerService.getReferenceById(id));
        }
        @Test
        void deleteById() {
            UserControllerService.deleteById(0L);
            assertNull(UserRepository.getReferenceById(0L));
        }

        @Test
        void findAll() {
            assertEquals(UserRepository.findAll(), UserControllerService.findAll());
        }

        @Test
        void findById() {
            assertEquals(UserControllerService.findById(-0L), Optional.empty());
        }
    }