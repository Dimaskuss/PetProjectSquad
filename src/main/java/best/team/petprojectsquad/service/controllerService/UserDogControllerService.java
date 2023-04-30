package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.UserDog;

import java.util.List;
import java.util.Optional;

public interface UserDogControllerService {
    boolean checkIfEntitiesExist(long id, long dogId);

    long save(UserDog userDog, long catId);

    UserDog getReferenceById(long id);
    void deleteById(long id);

    List<UserDog> findAll();

    Optional<UserDog> findById(long id);
}
