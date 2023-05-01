package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDogTest {

    @Test
    public void testGettersAndSetters() {
        UserDog userDog = new UserDog();
        userDog.setId(1);
        userDog.setChatId(123456789);
        userDog.setPhoneNumber("5551234");

        assertEquals(1, userDog.getId());
        assertEquals(123456789, userDog.getChatId());
        assertEquals("5551234", userDog.getPhoneNumber());
    }

    @Test
    public void testConstructor() {
        UserDog userDog = new UserDog(123456789);

        assertEquals(123456789, userDog.getChatId());
    }
}