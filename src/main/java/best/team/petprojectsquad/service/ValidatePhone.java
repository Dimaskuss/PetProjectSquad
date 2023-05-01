package best.team.petprojectsquad.service;

public interface ValidatePhone {

    default boolean checkPhone(String phone) {
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        return phone.matches(regex);
    }

}
