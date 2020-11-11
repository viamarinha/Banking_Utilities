package dev.andrylat.bankingutilities.validators;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardValidatorImplTest {

    @Test
    void customer_input_is_correct() {

            String customerInput = "4024007192661477";
            CardValidatorImpl cardValidatorImpl = new CardValidatorImpl();
            List<String> actual = cardValidatorImpl.customerDataTreatment(customerInput);
            assertEquals("ok", actual.get(0));

    }
    @Test
    void customer_input_wrong_control_number() {

        String customerInput = "4024 007192661478";
        CardValidatorImpl cardValidatorImpl = new CardValidatorImpl();
        List<String> actual = cardValidatorImpl.customerDataTreatment(customerInput);
        assertEquals("incorrect control number", actual.get(0));

    }
}