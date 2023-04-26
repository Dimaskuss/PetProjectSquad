package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.service.controllerService.UserDogControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDogControllerServiceImpl implements UserDogControllerService {
    private UserDogRepository userDogRepository;

    @Override
    public UserDog getReferenceById(long id) {
        return userDogRepository.getReferenceById(id);
    }

    @Override
    public long save(UserDog userDog) {
        userDogRepository.save(userDog);
        return userDog.getId();
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
