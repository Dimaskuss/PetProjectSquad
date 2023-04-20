package best.team.petprojectsquad.Cache;

import best.team.petprojectsquad.entity.BotState;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Getter
public class UserDataCache implements DataCache {

    private final Map<Long, BotState> usersBotStates = new HashMap<>();

    @Override
    public void setUsersCurrentBotState(long userId, BotState botState) {
        usersBotStates.put(userId, botState);
    }

    @Override
    public BotState getUsersCurrentBotState(long userId) {
        return usersBotStates.getOrDefault(userId, BotState.START);
    }
}
