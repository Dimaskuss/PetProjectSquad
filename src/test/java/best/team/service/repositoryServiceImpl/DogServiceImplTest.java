package best.team.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.repository.DogRepository;
import best.team.petprojectsquad.service.repositoryServiceImpl.DogServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DogServiceImplTest {

    @Mock
    DogRepository repository;

    @InjectMocks
    DogServiceImpl service;
    long id = 0L;
    Dog dog = new Dog(0,null,null,2018,null);

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