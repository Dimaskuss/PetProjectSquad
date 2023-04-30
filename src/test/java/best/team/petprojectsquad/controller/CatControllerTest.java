package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void shouldReturnRightObjectDelete() {

        when(catRepository.save(cat)).thenReturn(id);
        when(catRepository.get(id)).thenReturn(Optional.of(cat));
        ResponseEntity<Long> idEditCat = catController.editCat(id,cat);
        assertEquals(idEditCat.getBody(),id);
    }
}
