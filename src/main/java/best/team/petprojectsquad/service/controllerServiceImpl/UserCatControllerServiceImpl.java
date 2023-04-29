package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.service.controllerService.CatControllerService;
import best.team.petprojectsquad.service.controllerService.UserCatControllerService;
import best.team.petprojectsquad.service.controllerService.UserControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserCatControllerServiceImpl implements UserCatControllerService {
    private UserCatRepository userCatRepository;
    private UserControllerService userControllerService;

    private CatControllerService catControllerService;

    @Override
    public UserCat getReferenceById(long id) {
        return userCatRepository.findById(id).get();
    }

    @Override
    public boolean checkIfEntitiesExist(long id, long dogId) {
        return userControllerService.findById(id).isPresent() && catControllerService.findById(dogId).isPresent();
    }

    @Override
    public long save(UserCat userCat, long id, long catId) {
        userCat.setUser(userControllerService.getReferenceById(id));
        userCat.setCat(catControllerService.getReferenceById(catId));
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
