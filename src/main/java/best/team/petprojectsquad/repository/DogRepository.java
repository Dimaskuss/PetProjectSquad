package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog,Long> {

}
