package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.repository.ReportCatRepository;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReportCatServiceImpl implements RepositoryService<ReportCat> {

    private ReportCatRepository reportCatRepository;

    @Override
    public Optional<ReportCat> get(long id) {
        return reportCatRepository.findById(id);
    }

    @Override
    public long save(ReportCat reportCat) {
        return reportCatRepository.save(reportCat).getId();
    }

    @Override
    public void delete(long id) {
        reportCatRepository.deleteById(id);
    }

    @Override
    public List<ReportCat> findAll() {
        return reportCatRepository.findAll();
    }

    public List<ReportCat> findAllByUserCatId(long id) {
        return reportCatRepository.findAllByUserCatId(id);
    }
}
