package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DogControllerTest {
    @Mock
    RepositoryService<Dog> dogRepository;

    @InjectMocks
    private DogController dogController;

    private Dog dog = new Dog(0, null, null, 0, null);
    private Long id = 0L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {
        when(dogRepository.get(id)).thenReturn(Optional.ofNullable(dog));

        ResponseEntity<Dog> status = dogController.getDogById(0);

        assertEquals(status.getBody(), dog);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(dogRepository.save(dog)).thenReturn(id);
        ResponseEntity<Long> idNewDog = dogController.addDog(dog);
        assertEquals(idNewDog.getBody(), id);
    }

    @Test
    void shouldReturnIdEditedCat() {
        when(dogRepository.get(id)).thenReturn(Optional.ofNullable(dog));
        when(dogRepository.save(dog)).thenReturn(dog.getId());
        ResponseEntity<Long> idEditCat = dogController.editDog(id, dog);
        assertEquals(idEditCat.getBody(),id);

    }

    @Test
    void shouldReturnListCat() {
        List<Dog> list = new ArrayList<>();
        list.add(dog);
        when(dogRepository.findAll()).thenReturn(list);
        ResponseEntity<List<Dog>> listDog = dogController.getAll();
        assertEquals(Objects.requireNonNull(listDog.getBody()).size(), list.size());
    }

    @Test
    void shouldDeleteCat() {
        when(dogRepository.get(id)).thenReturn(Optional.ofNullable(dog));
        ResponseEntity<Void> actual = dogController.deleteDog(id);;
        assertNull(actual.getBody());
    }
}