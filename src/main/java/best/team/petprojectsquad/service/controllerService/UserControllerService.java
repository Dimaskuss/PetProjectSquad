package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserControllerService {
    User getReferenceById(long id);

    long save(User user);

    void deleteById(long id);

    List<User> findAll();

    Optional<User> findById(long id);
}
