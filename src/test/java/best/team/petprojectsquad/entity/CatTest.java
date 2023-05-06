package best.team.petprojectsquad.entity;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;



public class CatTest {

    @Test
    public void testGettersAndSetters() {
        Cat cat = new Cat();
        cat.setId(1);
        cat.setBreed("Persian");
        cat.setName("Fluffy");
        cat.setYearOfBirthday(2018);
        cat.setDescription("A cute and cuddly cat");

        assertEquals(1, cat.getId());
        assertEquals("Persian", cat.getBreed());
        assertEquals("Fluffy", cat.getName());
        assertEquals(2018, cat.getYearOfBirthday());
        assertEquals("A cute and cuddly cat", cat.getDescription());
    }

    @Test
    public void testConstructor() {
        Cat cat = new Cat(1, "Persian", "Fluffy", 2018, "A cute and cuddly cat");

        assertEquals(1, cat.getId());
        assertEquals("Persian", cat.getBreed());
        assertEquals("Fluffy", cat.getName());
        assertEquals(2018, cat.getYearOfBirthday());
        assertEquals("A cute and cuddly cat", cat.getDescription());
    }
}