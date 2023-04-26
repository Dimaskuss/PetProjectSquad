package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogTest {

    private UserDog userDog;
    @Test
    public void testGettersAndSetters() {
        Dog dog = new Dog();
        dog.setId(1);
        dog.setBreed("Golden Retriever");
        dog.setName("Buddy");
        dog.setYearOfBirthday(2015);
        dog.setDescription("A friendly and loyal dog");

        assertEquals(1, dog.getId());
        assertEquals("Golden Retriever", dog.getBreed());
        assertEquals("Buddy", dog.getName());
        assertEquals(2015, dog.getYearOfBirthday());
        assertEquals("A friendly and loyal dog", dog.getDescription());
    }

    @Test
    public void testConstructor() {
        Dog dog = new Dog(1, "Golden Retriever", "Buddy", 2015, "A friendly and loyal dog", userDog);

        assertEquals(1, dog.getId());
        assertEquals("Golden Retriever", dog.getBreed());
        assertEquals("Buddy", dog.getName());
        assertEquals(2015, dog.getYearOfBirthday());
        assertEquals("A friendly and loyal dog", dog.getDescription());

    }
}