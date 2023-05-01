package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserCatServiceImpl implements RepositoryService<UserCat> {

    private final UserCatRepository userCatRepository;

    @Override
    public Optional<UserCat> get(long id) {
        return userCatRepository.findById(id);
    }

    @Override
    public long save(UserCat userCat) {
        return userCatRepository.save(userCat).getId();
    }

    @Override
    public void delete(long id) {
        userCatRepository.deleteById(id);
    }

    @Override
    public List<UserCat> findAll() {
        return userCatRepository.findAll();
    }

    public Optional<UserCat> getByUser(User user) {
        return userCatRepository.findByUser(user);
    }
}
