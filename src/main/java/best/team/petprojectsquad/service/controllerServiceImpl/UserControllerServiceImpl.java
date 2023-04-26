package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.controllerService.UserControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserControllerServiceImpl implements UserControllerService {
    private UserRepository userRepository;

    @Override
    public User getReferenceById(long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public long save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
}
