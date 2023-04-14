package best.team.petprojectsquad.Cache;


import best.team.petprojectsquad.entity.BotState;

public interface DataCache {

    /**
     * Назначение статуса для бота
     * @param userId
     * @param botState статус бота, принимает значение из enum {@link BotState}
     */
    void setUsersCurrentBotState(long userId, BotState botState);

    BotState getUsersCurrentBotState(long userId);

}
