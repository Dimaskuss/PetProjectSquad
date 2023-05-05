package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.entity.ReportCat;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatControllerTest {

    @Mock
    RepositoryService<Cat> catRepository;

    @InjectMocks
    private CatController catController;

    private Cat cat = new Cat(0, null, null, 0, null);
    private Long id = 0L;

    @Test
    void shouldReturnRightObjectPassIdGetter() {

        when(catRepository.get(id)).thenReturn(Optional.of(cat));

        ResponseEntity<Cat> status = catController.getCatById(0);

        assertEquals(status.getBody(), cat);
    }

    @Test
    void shouldReturnRightObjectPassAdd() {

        when(catRepository.save(cat)).thenReturn(id);
        ResponseEntity<Long> idNewCat = catController.addCat(cat);
        assertEquals(idNewCat.getBody(),id);
    }

    @Test
    void shouldReturnIdEditedCat() {
        when(catRepository.get(id)).thenReturn(Optional.ofNullable(cat));
        when(catRepository.save(cat)).thenReturn(cat.getId());
        ResponseEntity<Long> idEditCat = catController.editCat(id, cat);
        assertEquals(idEditCat.getBody(),id);

    }

    @Test
    void shouldReturnListCat() {
        List<Cat> list = new ArrayList<>();
        list.add(cat);
        when(catRepository.findAll()).thenReturn(list);
        ResponseEntity<List<Cat>> listCat = catController.getAll();
        assertEquals(Objects.requireNonNull(listCat.getBody()).size(), list.size());
    }

    @Test
    void shouldDeleteCat() {
        when(catRepository.get(id)).thenReturn(Optional.ofNullable(cat));
        ResponseEntity<Void> actual = catController.deleteCat(id);;
        assertNull(actual.getBody());
    }
}
