package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.service.controllerService.UserCatControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserCatControllerServiceImpl implements UserCatControllerService {
    private UserCatRepository userCatRepository;

    @Override
    public UserCat getReferenceById(long id) {
        return userCatRepository.getReferenceById(id);
    }

    @Override
    public long save(UserCat userCat) {
        return userCatRepository.save(userCat).getId();
    }

    @Override
    public void deleteById(long id) {
        userCatRepository.deleteById(id);
    }

    @Override
    public List<UserCat> findAll() {
        return userCatRepository.findAll();
    }

    @Override
    public Optional<UserCat> findById(long id) {
        return userCatRepository.findById(id);
    }
}
