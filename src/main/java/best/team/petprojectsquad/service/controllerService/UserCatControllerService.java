package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.UserCat;

import java.util.List;
import java.util.Optional;

public interface UserCatControllerService {
    UserCat getReferenceById(long id);

    long save(UserCat userCat);

    void deleteById(long id);

    List<UserCat> findAll();

    Optional<UserCat> findById(long id);
}
