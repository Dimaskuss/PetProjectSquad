package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.*;
import best.team.petprojectsquad.repository.*;
import best.team.petprojectsquad.service.controllerService.UserDogControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDogControllerServiceImpl implements UserDogControllerService {
    private final DogRepository dogRepository;
    private final UserDogRepository userDogRepository;
    private final UserRepository userRepository;
    @Override
    public boolean checkIfEntitiesExist(long id, long dogId) {
        return userRepository.findById(id).isPresent() && dogRepository.findById(dogId).isPresent();
    }

    @Override
    public long save(UserDog userDog, long catId) {
        if (checkIfEntitiesExist(userDog.getUserId(), catId)) { //проверка
            userDog.setUserId(userDog.getUserId());
            userDog.setDog(dogRepository.findById(catId).get());
            return userDogRepository.save(userDog).getId();
        }
        throw new IllegalArgumentException();
    }


    @Override
    public UserDog getReferenceById(long id) {
        return userDogRepository.findById(id).get();
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
