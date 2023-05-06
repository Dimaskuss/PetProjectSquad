package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.ReportCat;
import jakarta.persistence.Cacheable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Cacheable
public interface ReportCatRepository extends JpaRepository<ReportCat, Long> {
    List<ReportCat> findAllByUserCatId(long id);
    //по айди можно менять reportAccepted
    @Transactional
    @Modifying
    @Query("update ReportCat report_cat set report_cat.reportAccepted = ?2 where report_cat.id = ?1")
    void setReportAcceptedBy(long id, boolean reportAccepted);
}
