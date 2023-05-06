package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserFeedBackService implements RepositoryService<UserFeedBack> {

    private final UserFeedBackRepository repository;

    @Override
    public Optional<UserFeedBack> get(long id) {
        return repository.findById(id);
    }

    @Override
    public long save(UserFeedBack userFeedBack) {
        return repository.save(userFeedBack).getId();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserFeedBack> findAll() {
        return repository.findAll();
    }

    public boolean existsByChatId(Long chatId) {
        return repository.existsByChatId(chatId);
    }
    }
