package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.UserDog;
import jakarta.persistence.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@Cacheable
public interface UserDogRepository extends JpaRepository<UserDog, Long> {

    boolean existsByChatId(long chatId);

    UserDog findByChatId(long chatId);
}
