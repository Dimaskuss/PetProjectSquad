package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setId(1);
        user.setChat_id(123456789);
        user.setName("John Doe");

        assertEquals(1, user.getId());
        assertEquals(123456789, user.getChat_id());
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testConstructor() {
        User user = new User(123456789, "John Doe");

        assertEquals(123456789, user.getChat_id());
        assertEquals("John Doe", user.getName());
    }
}