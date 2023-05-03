package best.team.petprojectsquad.entity;

public enum ShelterTypeOfTable {
    CAT_SHELTER("CAT"),
    DOG_SHELTER("DOG");

    public String getShelterTypeInString() {
        return shelterTypeInString;
    }

    private final String shelterTypeInString;

    ShelterTypeOfTable(String shelterTypeInString) {
        this.shelterTypeInString = shelterTypeInString;
    }
}
