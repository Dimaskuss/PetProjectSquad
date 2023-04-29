package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements RepositoryService<User> {

    private UserRepository userRepository;

    @Override
    public Optional<User> get(long id) {
        return userRepository.findById(id);
    }

    @Override
    public long save(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
