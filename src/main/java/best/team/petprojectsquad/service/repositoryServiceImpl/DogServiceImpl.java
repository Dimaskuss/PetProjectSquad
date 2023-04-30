package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.repository.DogRepository;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DogServiceImpl implements RepositoryService<Dog> {

    private DogRepository dogRepository;

    @Override
    public Optional<Dog> get(long id) {
        return dogRepository.findById(id);
    }

    @Override
    public long save(Dog dog) {
        return dogRepository.save(dog).getId();
    }

    @Override
    public void delete(long id) {
        dogRepository.deleteById(id);
    }

    @Override
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

}
