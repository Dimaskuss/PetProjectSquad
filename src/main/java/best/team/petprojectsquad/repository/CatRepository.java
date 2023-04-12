package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat,Long> {

}
