package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.UserDog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDogRepository extends JpaRepository<UserDog,Long> {
    boolean existsByChatId(long chatId);
    UserDog findByChatId(long chatId);
}
