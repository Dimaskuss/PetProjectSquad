package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.repository.ReportDogRepository;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReportDogServiceImpl implements RepositoryService<ReportDog> {

    private ReportDogRepository reportDogRepository;

    @Override
    public Optional<ReportDog> get(long id) {
        return reportDogRepository.findById(id);
    }

    @Override
    public long save(ReportDog reportDog) {
        return reportDogRepository.save(reportDog).getId();
    }

    @Override
    public void delete(long id) {
        reportDogRepository.deleteById(id);
    }

    @Override
    public List<ReportDog> findAll() {
        return reportDogRepository.findAll();
    }

}
