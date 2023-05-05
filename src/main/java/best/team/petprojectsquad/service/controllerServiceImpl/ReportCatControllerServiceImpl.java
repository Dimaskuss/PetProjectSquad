package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.ReportCatRepository;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.service.controllerService.ReportCatControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReportCatControllerServiceImpl implements ReportCatControllerService {

    private final ReportCatRepository repository;
    private final UserCatRepository userCatRepository;

    @Override
    public ReportCat getReferenceById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public long save(ReportCat reportCat, long userCatId) {
        UserCat userCat = userCatRepository.getReferenceById(userCatId);
        reportCat.setUserCat(userCat);
        return repository.save(reportCat).getId();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ReportCat> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ReportCat> findById(long id) {
        return repository.findById(id);
    }
}
