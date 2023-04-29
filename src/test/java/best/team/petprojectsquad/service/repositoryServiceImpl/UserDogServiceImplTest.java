package best.team.petprojectsquad.service.repositoryServiceImpl;

import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserDogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
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
    void save() {

        when(repository.save(userDog).getId()).thenReturn(id);
        assertEquals(service.save(userDog),id);
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
        ArrayList<UserDog> userDogArrayList = new ArrayList<>();
        userDogArrayList.add(userDog);
        when(repository.findAll()).thenReturn(userDogArrayList);
        assertEquals(service.findAll(), userDogArrayList);
    }
}