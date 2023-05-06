package best.team.petprojectsquad.service.controllerServiceImpl;
import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.service.controllerService.UserFeedBackControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserFeedBackControllerServiceImpl implements UserFeedBackControllerService {

    private final UserFeedBackRepository userFeedbackRepository;

    @Override
    public UserFeedBack getReferenceById(long id) {
        return userFeedbackRepository.getReferenceById(id);
    }


    @Override
    public long save(UserFeedBack userFeedBack) {
        userFeedbackRepository.save(userFeedBack);
        return userFeedBack.getChatId();
    }

    @Override
    public void deleteById(long id) {
        userFeedbackRepository.deleteById(id);
    }

    @Override
    public List<UserFeedBack> findAll() {
        return userFeedbackRepository.findAll();
    }

    @Override
    public Optional<UserFeedBack> findById(long id) {
        return userFeedbackRepository.findById(id);
    }

}
