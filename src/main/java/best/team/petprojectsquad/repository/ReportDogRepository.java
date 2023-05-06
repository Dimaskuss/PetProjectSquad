package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.ReportDog;
import jakarta.persistence.Cacheable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Cacheable
public interface ReportDogRepository extends JpaRepository<ReportDog, Long> {

    List<ReportDog> findAllByUserDogId(long id);
    @Transactional
    @Modifying
    @Query("update ReportDog report_dog set report_dog.reportAccepted = ?2 where report_dog.id = ?1")
    void setReportAcceptedBy(long id, boolean reportAccepted);
}
