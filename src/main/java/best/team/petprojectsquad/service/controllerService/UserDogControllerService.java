package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.*;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDogControllerService {

    private final RepositoryService<User> userService;
    private final RepositoryService<Dog> dogService;
    private final RepositoryService<UserDog> userDogService;

    public boolean checkIfEntitiesExist(long id, long dogId) {
        return userService.get(id).isPresent() && dogService.get(dogId).isPresent();
    }

    public long save(UserDog userDog, long id, long dogId) {
        userDog.setUser(userService.get(id).get());
        userDog.setDog(dogService.get(dogId).get());
        return userDogService.save(userDog);
    }
}
