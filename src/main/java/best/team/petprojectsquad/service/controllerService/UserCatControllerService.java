package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCatControllerService {

    private final RepositoryService<User> userService;
    private final RepositoryService<Cat> catService;
    private final RepositoryService<UserCat> userCatService;


    public boolean checkIfEntitiesExist(long id, long dogId) {
        return userService.get(id).isPresent() && catService.get(dogId).isPresent();
    }

    public long save(long userId, long catId,UserCat userCat ) {
        userCat.setUser(userService.get(userId).get());
        userCat.setCat(catService.get(catId).get());
        return userCatService.save(userCat);
    }
}
