package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.ReportDogRepository;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.service.controllerService.ReportDogControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReportDogControllerServiceImpl implements ReportDogControllerService {

    private final ReportDogRepository repository;
    private final UserDogRepository userDogRepository;

    @Override
    public ReportDog getReferenceById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public long save(ReportDog reportDog, long userDogId) {
        UserDog userDog = userDogRepository.findById(userDogId).get();
        reportDog.setUserDog(userDog);
        return repository.save(reportDog).getId();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ReportDog> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ReportDog> findById(long id) {
        return repository.findById(id);
    }
}
