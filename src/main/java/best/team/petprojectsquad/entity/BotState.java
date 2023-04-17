package best.team.petprojectsquad.entity;

public enum BotState {
    START("/start"),
    INFO("/info"),
    CAT_SHELTER_MENU("/catShelterMenu"),
    DOG_SHELTER_MENU("/dogShelterMenu");

    private final String state;

    BotState(String state) {
        this.state = state;
    }

    public String showState() {
        return state;
    }

}
