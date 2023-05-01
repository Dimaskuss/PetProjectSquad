package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserFeedBack;
import jakarta.persistence.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

@Cacheable
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByChatId(Long along);

    User getUserFeedBackByChatId(long chatId);
}
