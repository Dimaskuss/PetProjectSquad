package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.SuperUserVolunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperUserVolunteerRepository extends JpaRepository<SuperUserVolunteer, Long> {
    boolean existsByChatId(Long chatId);
}
