package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserDog;
import jakarta.persistence.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Cacheable
public interface UserDogRepository extends JpaRepository<UserDog, Long> {

    boolean existsByChatId(long chatId);

    UserDog findByChatId(long chatId);

    Optional<UserDog> findByUser(User user);
}
