package best.team.petprojectsquad.Cache;

import best.team.petprojectsquad.entity.BotState;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserDataCacheTest {

    private UserDataCache userDataCache = new UserDataCache();
    private BotState botState = BotState.START;
    long id = 1005223990L;


    @Test
    void setUsersCurrentBotState() {
        Map<Long, BotState> expected = new HashMap<>();
        expected.put(id, botState);

        userDataCache.setUsersCurrentBotState(id,botState);

        assertEquals(userDataCache.getUsersBotStates().get(id),expected.get(id));
        assertEquals(userDataCache.getUsersBotStates().get(id),expected.get(id));

    }

    @Test
    void getUsersCurrentBotState() {
        assertEquals(userDataCache.getUsersCurrentBotState(id),BotState.START);

        userDataCache.setUsersCurrentBotState(id,botState);

        assertEquals(userDataCache.getUsersCurrentBotState(id),botState);
        assertEquals(userDataCache.getUsersBotStates().get(id),userDataCache.getUsersCurrentBotState(id));
    }
}
