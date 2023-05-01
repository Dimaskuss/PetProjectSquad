package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDogServiceImpl implements RepositoryService<UserDog> {

    private UserDogRepository userDogRepository;

    @Override
    public Optional<UserDog>  get(long id) {
        return userDogRepository.findById(id);
    }

    @Override
    public long save(UserDog userDog) {
        return userDogRepository.save(userDog).getId();
    }

    @Override
    public void delete(long id) {
        userDogRepository.deleteById(id);
    }

    @Override
    public List<UserDog> findAll() {
        return userDogRepository.findAll();
    }

    public Optional<UserDog> getByUser(User user) {
        return userDogRepository.findByUser(user);
    }
}
