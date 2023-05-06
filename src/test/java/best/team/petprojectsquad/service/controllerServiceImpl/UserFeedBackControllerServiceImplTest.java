package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserFeedBackControllerServiceImplTest {
    @Mock
    UserFeedBackRepository userFeedbackRepository;
    @InjectMocks
    UserFeedBackControllerServiceImpl userFeedBackControllerServiceImpl;
    private long id = 0L;
    UserFeedBack userFeedBack = new UserFeedBack();

    @Test
    void shouldReturnUserFeedBackById() {
        when(userFeedbackRepository.getReferenceById(id)).thenReturn(userFeedBack);
        UserFeedBack actual = userFeedBackControllerServiceImpl.getReferenceById(id);
        Assertions.assertEquals(id, actual.getId());
    }

    @Test
    void shouldReturnIdSavedUserFeedBack() {
        when(userFeedbackRepository.save(userFeedBack)).thenReturn(userFeedBack);
        long actual = userFeedBackControllerServiceImpl.save(userFeedBack);
        Assertions.assertEquals(id, actual);
    }

    @Test
    void deleteById() {
//        Assertions.assertNull(userFeedBackControllerServiceImpl.deleteById(id));
    }

    @Test
    void findAll() {
        List<UserFeedBack> feedBackList = new ArrayList<>();
        when(userFeedbackRepository.findAll()).thenReturn(feedBackList);
        List<UserFeedBack> actual = userFeedBackControllerServiceImpl.findAll();
        Assertions.assertEquals(feedBackList, actual);
    }

    @Test
    void findById() {
        Optional<UserFeedBack> optionalUserFeedBack = Optional.of(new UserFeedBack());
        when(userFeedbackRepository.findById(id)).thenReturn(optionalUserFeedBack);
        Optional<UserFeedBack> actual = userFeedBackControllerServiceImpl.findById(id);
        Assertions.assertEquals(optionalUserFeedBack, actual);

    }

}