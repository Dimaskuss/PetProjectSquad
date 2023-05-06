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

    private UserRepository repository;

    @Override
    public Optional<User> get(long id) {
        return repository.findById(id);
    }

    @Override
    public long save(User user) {
        return repository.save(user).getId();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findByChatId(long chatId){ return repository.findByChatId(chatId);}
}
