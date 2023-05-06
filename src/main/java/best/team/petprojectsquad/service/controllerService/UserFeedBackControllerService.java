package best.team.petprojectsquad.service.controllerService;
import best.team.petprojectsquad.entity.UserFeedBack;

import java.util.List;
import java.util.Optional;

public interface UserFeedBackControllerService {

    UserFeedBack getReferenceById(long id);

    long save(UserFeedBack userFeedBack);

    void deleteById(long id);

    List<UserFeedBack> findAll();

    Optional<UserFeedBack> findById(long id);

}

