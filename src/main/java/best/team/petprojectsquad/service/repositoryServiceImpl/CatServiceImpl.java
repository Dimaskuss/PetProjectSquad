package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.repository.CatRepository;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatServiceImpl implements RepositoryService<Cat> {

    private CatRepository catRepository;

    @Override
    public Optional<Cat> get(long id) {
        return catRepository.findById(id);
    }

    @Override
    public long save(Cat cat) {
        return catRepository.save(cat).getId();
    }

    @Override
    public void delete(long id) {
        catRepository.deleteById(id);
    }

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

}
