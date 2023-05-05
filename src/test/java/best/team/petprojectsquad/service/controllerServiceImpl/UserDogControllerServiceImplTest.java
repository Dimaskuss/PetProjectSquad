package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.DogRepository;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDogControllerServiceImplTest {

    @Mock
    private DogRepository dogRepository;
    @Mock
    private UserDogRepository userDogRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserDogControllerServiceImpl service;
    long dogId = 1;
    long userId = 2;
    long userDogId = 3;
    UserDog userDog = new UserDog();
    Dog dog = new Dog();
    User user = new User();

    @Test
    void shouldReternTrueCheckIfEntitiesExist() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(dogRepository.findById(dogId)).thenReturn(Optional.of(dog));

        assertTrue(service.checkIfEntitiesExist(userId,dogId));
    }

    @Test
    void save() {
        userDog.setId(userDogId);
        when(userRepository.getReferenceById(userId)).thenReturn(user);
        when(dogRepository.findById(dogId)).thenReturn(Optional.of(dog));
        when(userDogRepository.save(userDog)).thenReturn(userDog);

        long actual = service.save(userDog,userId,dogId);

        assertEquals(userDogId, actual);
    }

    @Test
    void getReferenceById() {
        when(userDogRepository.findById(userDogId)).thenReturn(Optional.of(userDog));
        UserDog actual = service.getReferenceById(userDogId);
        assertEquals(userDog, actual);
    }

    @Test
    void deleteById() {
        service.deleteById(userDogId);
    }

    @Test
    void findAll() {
        List<UserDog> expected = new ArrayList<>();
        expected.add(userDog);
        when(userDogRepository.findAll()).thenReturn(expected);
        List<UserDog> actual = service.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findById() {
        when(userDogRepository.findById(userDogId)).thenReturn(Optional.of(userDog));
        Optional<UserDog> expected = Optional.of(userDog);
        Optional<UserDog> actual = service.findById(userDogId);

        assertEquals(expected, actual);
    }
}