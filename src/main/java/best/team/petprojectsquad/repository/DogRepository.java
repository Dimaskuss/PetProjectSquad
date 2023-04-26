package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.Dog;
import jakarta.persistence.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
@Cacheable
public interface DogRepository extends JpaRepository<Dog,Long> {
}
