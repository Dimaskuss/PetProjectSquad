package best.team.petprojectsquad.service;

import java.util.List;
import java.util.Optional;

public interface RepositoryService<T> {

    Optional<T> get(long id);

    long save(T entity);

    void delete(long id);

    List<T> findAll();

}
