package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperUserVolunteerTest {
    @Test
    public void testGettersAndSetters() {
        SuperUserVolunteer superUserVolunteer = new SuperUserVolunteer();
        superUserVolunteer.setId(1);
        superUserVolunteer.setName("Couldlie");
        superUserVolunteer.setChatId(123);

        assertEquals(1, superUserVolunteer.getId());
        assertEquals("Couldlie", superUserVolunteer.getName());
        assertEquals(123, superUserVolunteer.getChatId());
    }

    @Test
    public void testConstructor() {
        SuperUserVolunteer superUserVolunteer = new SuperUserVolunteer(1L);

        assertEquals(superUserVolunteer.getChatId(), 123);
        assertEquals(superUserVolunteer.getName(), "Couldlie");
        assertEquals(superUserVolunteer.getId(), 1);
    }

}