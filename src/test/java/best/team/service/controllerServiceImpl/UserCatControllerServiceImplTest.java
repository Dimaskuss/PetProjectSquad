package best.team.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.CatRepository;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.controllerServiceImpl.UserCatControllerServiceImpl;
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
class UserCatControllerServiceImplTest {
    @Mock
    private CatRepository catRepository;
    @Mock
    private UserCatRepository userCatRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserCatControllerServiceImpl service;
    long catId = 1;
    long userId = 2;
    long userCatId = 3;
    UserCat userCat = new UserCat();
    Cat cat = new Cat();
    User user = new User();

    @Test
    void shouldReternTrueCheckIfEntitiesExist() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(catRepository.findById(catId)).thenReturn(Optional.of(cat));

        assertTrue(service.checkIfEntitiesExist(userId,catId));
    }

    @Test
    void save() {
        userCat.setId(userCatId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(catRepository.findById(catId)).thenReturn(Optional.of(cat));
        when(userCatRepository.save(userCat)).thenReturn(userCat);

        long actual = service.save(catId,userId,userCat);

        assertEquals(userCatId, actual);
    }

    @Test
    void getReferenceById() {
        when(userCatRepository.findById(userCatId)).thenReturn(Optional.of(userCat));
        UserCat actual = service.getReferenceById(userCatId);
        assertEquals(userCat, actual);
    }

    @Test
    void deleteById() {
        service.deleteById(userCatId);
    }

    @Test
    void findAll() {
        List<UserCat> expected = new ArrayList<>();
        expected.add(userCat);
        when(userCatRepository.findAll()).thenReturn(expected);
        List<UserCat> actual = service.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findById() {
        when(userCatRepository.findById(userCatId)).thenReturn(Optional.of(userCat));
        Optional<UserCat> expected = Optional.of(userCat);
        Optional<UserCat> actual = service.findById(userCatId);

        assertEquals(expected, actual);
    }
}