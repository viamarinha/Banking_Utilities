package dev.andrylat.bankingutilities.validators;

import dev.andrylat.bankingutilities.interfaces.CardValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardValidatorImplTest {

    private CardValidator cardValidator;

    @BeforeEach
    void setUp() {

        cardValidator = new CardValidatorImpl();

    }

    @Test
    void validateControlNumber_numberIsOk_CustomerInputRightData() {

        String customerInput = "4024007192661477";
        List<String> actual = cardValidator.validate(customerInput);
        assertEquals("ok", actual.get(0));

    }

    @Test
    void validateControlNumber_PrintIncorrectControlNumber_ControlNumberNoGood() {

        String customerInput = "4024 007192661478";
        List<String> actual = cardValidator.validate(customerInput);
        assertEquals("incorrect control number", actual.get(0));

    }

    @Test
    void validate_Print2Messages_ShortControlNumber() {

        String customerInput = "7899";
        List<String> actual = cardValidator.validate(customerInput);
        assertEquals("wrong card number \n card number should starts within 2 - 6", actual.get(0));
        assertEquals("not enough digits in card number", actual.get(1));
    }

    @Test
    void validate_Print3Messages_AlphabeticalInput() {

        String customerInput = "A899";
        List<String> actual = cardValidator.validate(customerInput);
        assertEquals("wrong card number \n card number should starts within 2 - 6", actual.get(0));
        assertEquals("not enough digits in card number", actual.get(1));
        assertEquals("you have entered not a numeric digits", actual.get(2));
    }

    @Test
    void validate_PrintTooManyDigits_InputTooManyDigits() {

        String customerInput = "54478987858522222222";
        List<String> actual = cardValidator.validate(customerInput);
        assertEquals("too many digits in card number", actual.get(0));
    }

    @Test
    void validate_print3Messages_inputAlphanumericDigits() {

        String customerInput = "A784-8989-8888-8787-7777";
        List<String> actual = cardValidator.validate(customerInput);
        assertEquals("wrong card number \n card number should starts within 2 - 6", actual.get(0));
        assertEquals("too many digits in card number", actual.get(1));
        assertEquals("you have entered not a numeric digits", actual.get(2));
    }

    @Test
    void validate_printWrongCardNumber_inputWrongNumber() {

        String customerInput = "9784545454545454";
        List<String> actual = cardValidator.validate(customerInput);
        assertEquals("wrong card number \n card number should starts within 2 - 6", actual.get(0));
    }
}