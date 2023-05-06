package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserCatTest {

    @Test
    public void testGettersAndSetters() {
        UserCat userCat = new UserCat();
        userCat.setId(1);
        userCat.setChatId(123456789);
        userCat.setPhoneNumber("5551234");

        assertEquals(1, userCat.getId());
        assertEquals(123456789, userCat.getChatId());
        assertEquals("5551234", userCat.getPhoneNumber());
    }

    @Test
    public void testConstructor() {
        UserCat userCat = new UserCat(123456789);

        assertEquals(123456789, userCat.getChatId());
    }
}
