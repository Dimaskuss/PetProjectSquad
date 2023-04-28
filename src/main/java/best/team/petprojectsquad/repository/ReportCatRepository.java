package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.ReportCat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportCatRepository extends JpaRepository<ReportCat, Long> {

    List<ReportCat> findAllByUserCatId(long id);
}
