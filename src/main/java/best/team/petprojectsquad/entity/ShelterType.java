package best.team.petprojectsquad.entity;

public enum ShelterType {
    CAT_SHELTER("/catShalter"),
    DOG_SHELTER("/dogShalter");
    private final String shelterType;

    ShelterType(String shelterType) {
        this.shelterType = shelterType;
    }

}
