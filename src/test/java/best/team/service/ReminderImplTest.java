package best.team.service;

import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.service.ReminderImpl;
import best.team.petprojectsquad.service.repositoryServiceImpl.ReportCatServiceImpl;
import best.team.petprojectsquad.service.repositoryServiceImpl.ReportDogServiceImpl;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserCatServiceImpl;
import best.team.petprojectsquad.service.repositoryServiceImpl.UserDogServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReminderImplTest {

    @Mock
    private UserCatServiceImpl userCatRepository;
    @Mock
    private ReportCatServiceImpl reportCatRepository;
    @Mock
    private UserDogServiceImpl userDogRepository;
    @Mock
    private ReportDogServiceImpl reportDogRepository;

    @InjectMocks
    private ReminderImpl reminder;

    @Test
    void idUserToSendReminder() {

        List<UserCat> userCats = new ArrayList<>();
        when(userCatRepository.findAllUsersOnTrialPeriod()).thenReturn(userCats);

        List<UserDog> userDogs = new ArrayList<>();
        when(userDogRepository.findAllUsersOnTrialPeriod()).thenReturn(userDogs);

        reminder.idUserToSendReminder();
    }
}