package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.ReportDog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportDogRepository extends JpaRepository<ReportDog, Long> {
    List<ReportDog> findAllByUserDogId(long id);
}
