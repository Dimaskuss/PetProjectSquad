package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
