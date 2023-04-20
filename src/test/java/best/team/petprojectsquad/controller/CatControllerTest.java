package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class CatControllerTest{
    private Cat cat = new Cat(0, "ВОт", "Name", 2000, "Описание");
    private Long id = 0L;

    @Mock
    CatController catController;

    @Test
    void testingGetter() {
        catController.addCat(cat);
        ResponseEntity<Cat> catById = catController.getCatById(0);
        System.out.println("Good");
    }
}
