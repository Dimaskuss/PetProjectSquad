package best.team.petprojectsquad.service;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.ReportCatRepository;
import best.team.petprojectsquad.repository.ReportDogRepository;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.repository.UserDogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class ReminderImpl implements Reminder {

    private final UserCatRepository userCatRepository;
    private final ReportCatRepository reportCatRepository;
    private final UserDogRepository userDogRepository;
    private final ReportDogRepository reportDogRepository;

    @Override
    public List<Long> idUserToSendReminder() {
        List<Long> idUser = new ArrayList<>();
        idUser.addAll(catIdUserFail());
        idUser.addAll(dogIdUserFail());
        return idUser;
    }

    private List<Long> catIdUserFail() { //todo реализовать выборку в базе а не на сервере в стриме
        return userCatRepository.findAll().stream().
                filter(userCat -> userCat.getTrialPeriod() > 0).
                map(UserCat::getId).filter(userId -> getPeriodCat(userId) > 1).toList();
    }

    private int getPeriodCat(long id) {
        List<ReportCat> reportCat = reportCatRepository.findAllByUserCatId(id).stream().
                sorted(Comparator.comparing(ReportCat::getDateReport)).toList();
        Period period = Period.between(LocalDate.from(LocalDate.now()), reportCat.get(reportCat.size() - 1).getDateReport());
        return Math.abs(period.getDays());
    }

    private List<Long> dogIdUserFail() { //todo реализовать выборку в базе а не на сервере в стриме
        return userDogRepository.findAll().stream().
                filter(userDog -> userDog.getTrialPeriod() > 0).
                map(UserDog::getId).filter(userId -> getPeriodDog(userId) > 1).toList();
    }

    private int getPeriodDog(long id) {
        List<ReportDog> reportDog = reportDogRepository.findAllByUserDogId(id).stream().
                sorted(Comparator.comparing(ReportDog::getDateReport)).toList();
        Period period = Period.between(
                LocalDate.from(LocalDate.now()),
                reportDog.get(reportDog.size() - 1).getDateReport());
        return Math.abs(period.getDays());
    }
}
