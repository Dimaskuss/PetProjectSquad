package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.UserDog;

import java.util.List;
import java.util.Optional;

public interface UserDogControllerService {
    UserDog getReferenceById(long id);

    long save(UserDog userDog);

    void deleteById(long id);

    List<UserDog> findAll();

    Optional<UserDog> findById(long id);
}
