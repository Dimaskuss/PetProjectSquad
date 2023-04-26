package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.Dog;

import java.util.List;
import java.util.Optional;

public interface DogControllerService {
    Dog getReferenceById(long id);

    long save(Dog dog);

    void deleteById(long id);

    List<Dog> findAll();

    Optional<Dog> findById(long id);
}
