package best.team.petprojectsquad.entity;

public enum BotState {
    START("/start"),
    INFO("/info");

    private final String state;

    BotState(String state) {
        this.state = state;
    }

    public String showState() {
        return state;
    }

}
