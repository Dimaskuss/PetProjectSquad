package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.UserCat;

import java.util.List;
import java.util.Optional;

public interface UserCatControllerService {
    long save(long catId, long id, UserCat userCat);

    UserCat getReferenceById(long id);

    void deleteById(long id);

    List<UserCat> findAll();

    Optional<UserCat> findById(long id);

    boolean checkIfEntitiesExist(long id, long dogId);

}
