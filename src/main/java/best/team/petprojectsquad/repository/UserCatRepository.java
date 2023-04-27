package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.UserCat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCatRepository extends JpaRepository<UserCat, Long> {
    boolean existsByChatId(long chatId);
    UserCat findByChatId(long chatId);
}
