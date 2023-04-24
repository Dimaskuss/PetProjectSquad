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

    CAT_SHELTER_CALLBACK("/catCallback"),
    DOG_SHELTER_CALLBACK("/dogCallback"),
    CAT_TAKE_INFO("/catTakeInfo"),
    DOG_TAKE_INFO("/dogTakeInfo"),

    RULES_TAKE_CAT("/rulesBeforeGettingCat"),
    RULES_TAKE_DOG("/rulesBeforeGettingDog"),
    CAT_TAKE_DOCUMENTS("/catListOfDocuments"),
    DOG_TAKE_DOCUMENTS("/dogListOfDocuments"),
    CAT_TRANSPORT_RECOMMENDATION("/catTransportRecommendations"),
    DOG_TRANSPORT_RECOMMENDATION("/dogTransportRecommendations"),
    HOME_RECOMMENDATION_KITTEN("/homeRecommendationsKitten"),
    HOME_RECOMMENDATION_PUPPY("/homeRecommendationsPuppy"),
    HOME_RECOMMENDATION_ADULT_CAT("/homeRecommendationsAdultCat"),
    HOME_RECOMMENDATION_ADULT_DOG("/homeRecommendationsAdultDog"),
    HOME_RECOMMENDATION_DIS_CAT("/homeRecommendationsCatWithDisabilities"),
    HOME_RECOMMENDATION_DIS_DOG("/homeRecommendationsDogWithDisabilities"),
    DOG_TIPS_TRAINER("/tipsDogTrainer"),
    VERIFIED_TRAINERS("/listVerifiedDogTrainers"),
    DOG_TAKE_NEGATIVE("/dogListReasonsNegative"),
    CONTACTS_CAT("/catSendContact"),
    CONTACTS_DOG("/dogSendContact");


    private final String state;

    BotState(String state) {
        this.state = state;
    }

    public String showState() {
        return state;
    }

}
