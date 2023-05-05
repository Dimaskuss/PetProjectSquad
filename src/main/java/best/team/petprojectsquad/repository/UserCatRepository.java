package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserCat;
import jakarta.persistence.Cacheable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Cacheable
public interface UserCatRepository extends JpaRepository<UserCat, Long> {

    boolean existsByChatId(long chatId);

    UserCat findByChatId(long chatId);

    Optional<UserCat> findByUser(User user);

    List<UserCat> findAllByTrialPeriodIsGreaterThan(int trialPeriod);

    @Transactional
    @Modifying
    @Query("UPDATE UserCat userCat set userCat.trialPeriod = userCat.trialPeriod - 1 where userCat.id = ?1")
    void setTrialPeriodMinus1(long id);
}
