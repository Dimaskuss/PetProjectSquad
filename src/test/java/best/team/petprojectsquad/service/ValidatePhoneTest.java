package best.team.petprojectsquad.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePhoneTest {

    private ValidatePhone validatePhone = new ValidatePhone() {
        @Override
        public boolean checkPhone(String phone) {
            return ValidatePhone.super.checkPhone(phone);
        }
    };

    @Test
    void shouldReturnFalseCheckPhone() {
        assertFalse(validatePhone.checkPhone("983"));

    }
    @Test
    void shouldReturnTrueCheckPhone() {
        assertTrue(validatePhone.checkPhone("+79219212121"));

    }
}