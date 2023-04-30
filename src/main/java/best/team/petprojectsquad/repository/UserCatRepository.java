package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.UserCat;
import jakarta.persistence.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@Cacheable
public interface UserCatRepository extends JpaRepository<UserCat, Long> {

    boolean existsByChatId(long chatId);

    UserCat findByChatId(long chatId);
}
