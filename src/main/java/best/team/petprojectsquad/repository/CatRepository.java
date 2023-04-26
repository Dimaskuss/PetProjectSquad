package best.team.petprojectsquad.repository;

import best.team.petprojectsquad.entity.Cat;
import jakarta.persistence.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

//Эта и последующие аннотации означают, что результат выполнения функций API будет сохраняться в кеше(RAM пользователя)
//Что в последствии увеличит производительность, уменьшит вероятное кол-во запросов в БД
@Cacheable
public interface CatRepository extends JpaRepository<Cat,Long> {

}
