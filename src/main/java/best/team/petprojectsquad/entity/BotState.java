package best.team.petprojectsquad.entity;

public enum BotState {
    START("/start"),
    INFO("/info"),
    CAT_SHELTER_MENU("/catShelterMenu"),
    DOG_SHELTER_MENU("/dogShelterMenu"),
    CAT_SHELTER_ADDRESS("/catShelterAddress"),
    DOG_SHELTER_ADDRESS("/dogShelterAddress"),
    WORK_SCHEDULE("/workSchedule"),
    ADMISSION_RULES("/admissionRules"),
    INSIDE_RULES("/insideRules");

    private final String state;

    BotState(String state) {
        this.state = state;
    }

    public String showState() {
        return state;
    }

}
