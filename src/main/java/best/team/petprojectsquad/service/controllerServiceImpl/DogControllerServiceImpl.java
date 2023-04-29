package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.repository.DogRepository;
import best.team.petprojectsquad.service.controllerService.DogControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DogControllerServiceImpl implements DogControllerService {
    private DogRepository dogRepository;

    @Override
    public Dog getReferenceById(long id) {
        return dogRepository.findById(id).get();
    }

    @Override
    public long save(Dog dog) {
        return dogRepository.save(dog).getId();
    }

    @Override
    public void deleteById(long id) {
        dogRepository.deleteById(id);
    }

    @Override
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }
    @Override
    public Optional<Dog> findById(long id) {
        return dogRepository.findById(id);
    }
}
