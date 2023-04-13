package best.team.petprojectsquad.Cache;


import best.team.petprojectsquad.entity.BotState;

public interface DataCache {

    void setUsersCurrentBotState(long userId, BotState botState);

    BotState getUsersCurrentBotState(long userId);

}
