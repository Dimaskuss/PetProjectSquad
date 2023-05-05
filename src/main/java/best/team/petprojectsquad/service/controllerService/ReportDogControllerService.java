package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.ReportDog;

import java.util.List;
import java.util.Optional;

public interface ReportDogControllerService {
    ReportDog getReferenceById(long id);

    long save(ReportDog reportDog, long userDogId);

    void deleteById(long id);

    List<ReportDog> findAll();

    Optional<ReportDog> findById(long id);
}
