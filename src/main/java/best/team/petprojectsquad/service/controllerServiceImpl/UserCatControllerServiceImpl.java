package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.CatRepository;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.controllerService.UserCatControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserCatControllerServiceImpl implements UserCatControllerService {
    private final CatRepository catRepository;
    private final UserCatRepository userCatRepository;
    private final UserRepository userRepository;
    @Override
    public boolean checkIfEntitiesExist(long id, long catId) {
        return userRepository.findById(id).isPresent() && catRepository.findById(catId).isPresent();
    }

    @Override
    public long save(long catId, UserCat userCat) {
        if (checkIfEntitiesExist(userCat.getUserId(), catId)) { //проверка
            userCat.setUserId(userCat.getUserId());
            userCat.setCat(catRepository.findById(catId).get());
            return userCatRepository.save(userCat).getId();
        }
        throw new IllegalArgumentException();
    }


    @Override
    public UserCat getReferenceById(long id) {
        return userCatRepository.findById(id).get();
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
