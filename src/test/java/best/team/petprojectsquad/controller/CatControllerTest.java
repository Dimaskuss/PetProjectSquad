package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CatControllerTest{
    private Cat cat = new Cat(0, "ВОт", "Test,you may delete this", 2000, "Описание");
    private Long id = 0L;

    @Autowired
    CatController catController;

    @Test
    void testingGetter() {
        catController.addCat(cat);
        ResponseEntity<Cat> catById = catController.getCatById(0);
        assertEquals(catById.getBody(), cat);
    }
    @Test
    public void contextLoads() {
        assertThat(catController).isNotNull();
    }
}
