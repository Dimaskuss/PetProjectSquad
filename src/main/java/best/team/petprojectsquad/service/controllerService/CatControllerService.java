package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.Cat;

import java.util.List;
import java.util.Optional;

public interface CatControllerService {
    Cat getReferenceById(long id);
    long save(Cat cat);
    void deleteById(long id);
    List<Cat> findAll();
    Optional<Cat> findById(long id);
}
