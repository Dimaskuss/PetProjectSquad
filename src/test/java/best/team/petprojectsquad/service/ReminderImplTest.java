package best.team.petprojectsquad.service;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
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
        List<ReportCat> reportCats = new ArrayList<>();

        when(userCatRepository.findAllUsersOnTrialPeriod()).thenReturn(userCats);
        when(reportCatRepository.findAllByUserCatId(1)).thenReturn(reportCats);

        List<UserDog> userDogs = new ArrayList<>();
        List<ReportDog> reportDogs = new ArrayList<>();

        when(userDogRepository.findAllUsersOnTrialPeriod()).thenReturn(userDogs);
        when(reportDogRepository.findAllByUserDogId(1)).thenReturn(reportDogs);




        reminder.idUserToSendReminder();
    }

}