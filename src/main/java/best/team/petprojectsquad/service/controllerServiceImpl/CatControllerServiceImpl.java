package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.repository.CatRepository;
import best.team.petprojectsquad.service.controllerService.CatControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatControllerServiceImpl implements CatControllerService {
    private CatRepository catRepository;

    @Override
    public Cat getReferenceById(long id) {
        return catRepository.findById(id).get();
    }

    @Override
    public long save(Cat cat) {
        return catRepository.save(cat).getId();
    }

    @Override
    public void deleteById(long id) {
        catRepository.deleteById(id);
    }

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }
    @Override
    public Optional<Cat> findById(long id) {
        return catRepository.findById(id);
    }
}
