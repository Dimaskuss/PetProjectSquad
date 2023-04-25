package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.UserFeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFeedBackRepository extends JpaRepository<UserFeedBack, Long> {
    boolean existsByChatId(Long chatId);
}
