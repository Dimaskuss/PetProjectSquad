package best.team.petprojectsquad.entity;

public enum BotState {
    START("/start"),
    INFO("/info"),
    CALL_VOLUNTEER("/callVolunteer"),
    VALIDATE_PHONE("/validatePhone"),
    CAT_SHELTER_MENU("/catShelterMenu"),
    DOG_SHELTER_MENU("/dogShelterMenu"),
    CAT_INFO_MENU("/catInfoMenu"),
    DOG_INFO_MENU("/dogInfoMenu"),
    CAT_SHELTER_INFO("/catInfo"),
    DOG_SHELTER_INFO("/dogInfo"),
    CAT_SHELTER_ADDRESS("/catAddress"),
    DOG_SHELTER_ADDRESS("/dogAddress"),
    CAT_SHELTER_PASS("/catPass"),
    DOG_SHELTER_PASS("/dogPass"),
    CAT_SHELTER_SAFETY("/catSafety"),
    DOG_SHELTER_SAFETY("/dogSafety"),
    SHELTER_CALLBACK("/callback"),
    SUPER_USER_VOLUNTEER("/superUser"),
    VALIDATE_VOLUNTEER("/volunteerValidate");
    private final String state;

    BotState(String state) {
        this.state = state;
    }

    public String showState() {
        return state;
    }

}
