package dev.andrylat.bankingutilities.validators;

import dev.andrylat.bankingutilities.interfaces.CardValidator;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CardValidatorImplTest {

    @Test
    void customer_input_is_correct() {

            String customerInput = "4024007192661477";
        CardValidator cardValidator = new CardValidatorImpl();
            List<String> actual = cardValidator.customerDataTreatment(customerInput);
            assertEquals("ok", actual.get(0));

    }
    @Test
    void customer_input_wrong_control_number() {

        String customerInput = "4024 007192661478";
        CardValidator cardValidator  = new CardValidatorImpl();
        List<String> actual = cardValidator.customerDataTreatment(customerInput);
        assertEquals("incorrect control number", actual.get(0));

    }

    @Test
    void customer_input_not_enough_digits(){
        String customerInput = "7899";
        CardValidator cardValidator  = new CardValidatorImpl();
        List<String> actual = cardValidator.customerDataTreatment(customerInput);
        assertEquals("wrong card number \n card number should starts within 2 - 6",actual.get(0));
        assertEquals("not enough digits in card number",actual.get(1));
    }
    @Test
    void customer_input_not_enough_digits_alphabetical_character(){
        String customerInput = "A899";
        CardValidator cardValidator  = new CardValidatorImpl();
        List<String> actual = cardValidator.customerDataTreatment(customerInput);
        assertEquals("wrong card number \n card number should starts within 2 - 6",actual.get(0));
        assertEquals("not enough digits in card number",actual.get(1));
        assertEquals("you have entered not a numeric digits",actual.get(2));
    }
    @Test
    void customer_input_too_many_digits(){
        String customerInput = "54478987858522222222";
        CardValidator cardValidator  = new CardValidatorImpl();
        List<String> actual = cardValidator.customerDataTreatment(customerInput);
        assertEquals("too many digits in card number",actual.get(0));
    }
    @Test
    void customer_input_too_many_digits_alphabetical_character(){
        String customerInput = "A784-8989-8888-8787-7777";
        CardValidator cardValidator  = new CardValidatorImpl();
        List<String> actual = cardValidator.customerDataTreatment(customerInput);
        assertEquals("wrong card number \n card number should starts within 2 - 6",actual.get(0));
        assertEquals("too many digits in card number",actual.get(1));
        assertEquals("you have entered not a numeric digits",actual.get(2));
    }

    @Test
    void customer_input_not_a_banking_card(){
        String customerInput = "9784545454545454";
        CardValidator cardValidator = new CardValidatorImpl();
        List<String> actual = cardValidator.customerDataTreatment(customerInput);
        assertEquals("wrong card number \n card number should starts within 2 - 6",actual.get(0));
    }
}