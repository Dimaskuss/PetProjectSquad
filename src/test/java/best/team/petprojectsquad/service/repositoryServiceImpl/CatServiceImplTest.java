package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatServiceImplTest {

    @Mock
    CatRepository repository;

    @InjectMocks
    CatServiceImpl service;
    long id = 0L;
    Cat cat = new Cat(0,null,null,2018,null);

    @Test
    void ShouldReturnRightReferenceById() {
        assertEquals(repository.findById(id), service.get(id));
    }
    @Test
    void deleteById() {
        service.delete(0L);
        assertNull(repository.getReferenceById(0L));
    }

    @Test
    void findAll() {
        assertEquals(repository.findAll(), service.findAll());
    }

    @Test
    void findById() {
        assertEquals(service.get(-0L), Optional.empty());
    }
}