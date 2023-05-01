package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.SuperUserVolunteer;
import best.team.petprojectsquad.repository.SuperUserVolunteerRepository;
import best.team.petprojectsquad.service.controllerService.SuperUserVolunteerControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class SuperUserVolunteerServiceImpl implements SuperUserVolunteerControllerService {

    private final SuperUserVolunteerRepository superUserVolunteerRepository;

    @Override
    public SuperUserVolunteer getReferenceById(long id) {
        return superUserVolunteerRepository.getReferenceById(id);
    }

    @Override
    public long save(SuperUserVolunteer superUserVolunteer) {
        superUserVolunteerRepository.save(superUserVolunteer);
        return superUserVolunteer.getChatId();
    }

    @Override
    public void deleteById(long id) {
        superUserVolunteerRepository.deleteById(id);
    }

    @Override
    public List<SuperUserVolunteer> findAll() {
        return superUserVolunteerRepository.findAll();
    }

    @Override
    public Optional<SuperUserVolunteer> findById(long id) {
        return superUserVolunteerRepository.findById(id);
    }
}
