package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.ReportCat;

import java.util.List;
import java.util.Optional;

public interface ReportCatControllerService {
    ReportCat getReferenceById(long id);

    long save(ReportCat reportCat, long userCatId);

    void deleteById(long id);

    List<ReportCat> findAll();

    Optional<ReportCat> findById(long id);
}
