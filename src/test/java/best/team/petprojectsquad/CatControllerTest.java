package best.team.petprojectsquad;

import best.team.petprojectsquad.controller.CatController;
import best.team.petprojectsquad.entity.Cat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
 class CatControllerTest {
    @Mock
    private CatController catController;

    @Test
     void shouldReturnRightObjectPassId() {
        Cat cat = new Cat(0, null,null,0, null);
        catController.addCat(cat);
        Cat cat2 = catController.getCatById(cat.getId()).getBody();
        assertEquals(cat2.getName(), null);
        assertEquals(cat2.getBreed(), null);
        assertEquals(cat2.getDescription(), null);
        assertEquals(cat2.getYearOfBirthday(), 0);
    }
}
