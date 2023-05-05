package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserDog;
import jakarta.persistence.Cacheable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Cacheable
public interface UserDogRepository extends JpaRepository<UserDog, Long> {

    boolean existsByChatId(long chatId);

    UserDog findByChatId(long chatId);

    Optional<UserDog> findByUser(User user);

    List<UserDog> findAllByTrialPeriodIsGreaterThan(int trialPeriod);

    @Transactional
    @Modifying
    @Query("UPDATE UserDog userDog set userDog.trialPeriod = userDog.trialPeriod - 1 where userDog.id = ?1")
    void setTrialPeriodMinus1(long id);

    @Transactional
    @Modifying
    @Query("UPDATE UserDog userDog set userDog.status = ?2 where userDog.id = ?1")
    void setUserDogStatus(long id, String status);
}
