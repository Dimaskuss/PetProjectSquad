package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.service.controllerService.DogControllerService;
import best.team.petprojectsquad.service.controllerService.UserControllerService;
import best.team.petprojectsquad.service.controllerService.UserDogControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDogControllerServiceImpl implements UserDogControllerService {
    private UserDogRepository userDogRepository;
    private final UserControllerService userControllerService;
    private final DogControllerService dogControllerService;
    @Override
    public UserDog getReferenceById(long id) {
        return userDogRepository.findById(id).get();
    }
    @Override
    public boolean checkIfEntitiesExist(long id, long dogId) {
        return userControllerService.findById(id).isPresent() && dogControllerService.findById(dogId).isPresent();
    }
    @Override
    public long save(UserDog userDog, long id, long dogId) {
        userDog.setUser(userControllerService.getReferenceById(id));
        userDog.setDog(dogControllerService.getReferenceById(dogId));
            return userDogRepository.save(userDog).getId();
    }

    @Override
    public void deleteById(long id) {
        userDogRepository.deleteById(id);
    }

    @Override
    public List<UserDog> findAll() {
        return userDogRepository.findAll();
    }

    @Override
    public Optional<UserDog> findById(long id) {
        return userDogRepository.findById(id);
    }
}
