package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByChatId(Long along);
}
