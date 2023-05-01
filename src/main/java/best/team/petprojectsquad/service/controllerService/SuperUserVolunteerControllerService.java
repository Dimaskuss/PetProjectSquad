package best.team.petprojectsquad.service.controllerService;

import best.team.petprojectsquad.entity.SuperUserVolunteer;

import java.util.List;
import java.util.Optional;

public interface SuperUserVolunteerControllerService {
    SuperUserVolunteer getReferenceById(long id);

    long save(SuperUserVolunteer superUserVolunteer);

    void deleteById(long id);

    List<SuperUserVolunteer> findAll();

    Optional<SuperUserVolunteer> findById(long id);

}
