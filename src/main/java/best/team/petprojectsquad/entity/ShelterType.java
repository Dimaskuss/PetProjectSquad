package best.team.petprojectsquad.entity;

public enum ShelterType {
    CAT_SHELTER("/catShelter"),
    DOG_SHELTER("/dogShelter");
    private final String shelterType;

    ShelterType(String shelterType) {
        this.shelterType = shelterType;
    }

}
