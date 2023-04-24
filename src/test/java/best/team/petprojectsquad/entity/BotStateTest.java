package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BotStateTest {

    @Test
    public void testShowState() {
        assertEquals("/start", BotState.START.showState());
        assertEquals("/info", BotState.INFO.showState());
        assertEquals("/callVolunteer", BotState.CALL_VOLUNTEER.showState());
        assertEquals("/validatePhone", BotState.VALIDATE_PHONE.showState());
        assertEquals("/catShelterMenu", BotState.CAT_SHELTER_MENU.showState());
        assertEquals("/dogShelterMenu", BotState.DOG_SHELTER_MENU.showState());
        assertEquals("/catInfoMenu", BotState.CAT_INFO_MENU.showState());
        assertEquals("/dogInfoMenu", BotState.DOG_INFO_MENU.showState());
        assertEquals("/catInfo", BotState.CAT_SHELTER_INFO.showState());
        assertEquals("/dogInfo", BotState.DOG_SHELTER_INFO.showState());
        assertEquals("/catAddress", BotState.CAT_SHELTER_ADDRESS.showState());
        assertEquals("/dogAddress", BotState.DOG_SHELTER_ADDRESS.showState());
        assertEquals("/catPass", BotState.CAT_SHELTER_PASS.showState());
        assertEquals("/dogPass", BotState.DOG_SHELTER_PASS.showState());
        assertEquals("/catSafety", BotState.CAT_SHELTER_SAFETY.showState());
        assertEquals("/dogSafety", BotState.DOG_SHELTER_SAFETY.showState());
        assertEquals("/callback", BotState.SHELTER_CALLBACK.showState());
    }
}
