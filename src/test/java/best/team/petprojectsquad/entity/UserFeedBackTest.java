package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFeedBackTest {
    String phoneNumber = "89116754233";
    long chatId = 123;

    @Test
    public void testGettersAndSetters() {
        UserFeedBack userFeedBack = new UserFeedBack();
        userFeedBack.setId(1);
        userFeedBack.setName("Couldlie");
        userFeedBack.setFeedback(true);
        userFeedBack.setChatId(chatId);
        userFeedBack.setPhoneNumber(phoneNumber);

        assertEquals(1, userFeedBack.getId());
        assertEquals("Couldlie", userFeedBack.getName());
        assertTrue(userFeedBack.isFeedback());
        assertEquals(chatId, userFeedBack.getChatId());
        assertEquals(phoneNumber, userFeedBack.getPhoneNumber());
    }

    @Test
    public void testConstructor() {
        UserFeedBack userFeedBack = new UserFeedBack(phoneNumber, chatId, "Couldlie");

        assertEquals(userFeedBack.getChatId(), 123);
        assertEquals(userFeedBack.getPhoneNumber(), phoneNumber);
        assertTrue(userFeedBack.isFeedback());
        assertEquals(userFeedBack.getName(), "Couldlie");
    }
}