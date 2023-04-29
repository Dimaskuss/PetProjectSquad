package best.team.petprojectsquad.Cache;

import best.team.petprojectsquad.entity.BotState;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
@Getter
public class UserDataCache implements DataCache {

    private final Map<Long, BotState> usersBotStates = new HashMap<>();

    @Override
    public void setUsersCurrentBotState(long userId, BotState botState) {
        log.info("bot state from userId:{}, botState: {}"
                , userId
                , botState);
        usersBotStates.put(userId, botState);
    }

    @Override
    public BotState getUsersCurrentBotState(long userId) {
        return usersBotStates.getOrDefault(userId, BotState.START);
    }
}
