package best.team.petprojectsquad.entity;

/**
 * Статус испытательного срока
 */
public enum StatusOfDecision {
    EXTENSION_FOR_14_DAYS("Extension for 14 days"),
    EXTENSION_FOR_30_DAYS("Extension for 30 days"),
    SUCCESSFULLY_PASSED("Passed successfully!"),
    NOT_PASSED("Not passed");

    private final String state;

    StatusOfDecision(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
