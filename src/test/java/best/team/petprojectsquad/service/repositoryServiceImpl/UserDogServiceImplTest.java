package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserDogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDogServiceImplTest {

    @Mock
    private UserDogRepository repository;

    @InjectMocks
    UserDogServiceImpl service;
    long id = 1L;
    UserDog userDog = new UserDog(4161L);

    @Test
    void ShouldReturnRightReferenceById() {

        when(repository.findById(id)).thenReturn(Optional.of(userDog));
        assertEquals(service.get(id), Optional.of(userDog));
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