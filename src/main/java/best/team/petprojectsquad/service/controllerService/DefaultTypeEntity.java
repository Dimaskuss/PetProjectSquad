package best.team.petprojectsquad.service.controllerService;

import java.util.List;
import java.util.Optional;

public interface DefaultTypeEntity <T> {
    T getReferenceById(long id);

    long save(T entity);

    void deleteById(long id);

    List<T> findAll();

    Optional<T> findById(long id);
}
