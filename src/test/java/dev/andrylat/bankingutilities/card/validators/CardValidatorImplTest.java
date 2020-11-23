package dev.andrylat.bankingutilities.card.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardValidatorImplTest {

    private CardValidator cardValidator;

    @BeforeEach
    void setUp() {

        cardValidator = new CardValidatorImpl();
    }

    @Test
    void validateControlNumber_ShouldReturnEmptyList_WhenInputRightData() {

        String customerInput = "4024007192661477";
        List<String> actual = cardValidator.validate(customerInput);
        List<String> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    void validateControlNumber_ShouldReturnIncorrectControlNumber_WhenControlNumberNoGood() {

        String customerInput = "4024 007192661478";
        List<String> errorsList = cardValidator.validate(customerInput);
        String[] actual = errorsList.stream().toArray(String[]::new);
        String[] expected = {"incorrect control number"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validate_ShouldReturn2ErrorsMessages_WhenFirstNumberNotIn2To6AndNotEnoughDigits() {

        String customerInput = "7899";
        List<String> errorsList = cardValidator.validate(customerInput);
        String[] actual = errorsList.stream().toArray(String[]::new);
        String[] expected = {"wrong card number \n card number should starts within 2 - 6", "not enough digits in card number"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validate_ShouldReturn3ErrorMessages_WhenNotEnoughDigitsAndAlphabeticalChars() {

        String customerInput = "A899";
        List<String> errorsList = cardValidator.validate(customerInput);
        String[] actual = errorsList.stream().toArray(String[]::new);
        String[] expected = {"wrong card number \n card number should starts within 2 - 6",
                "not enough digits in card number", "you have entered not a numeric digits"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validate_ShouldReturnTooManyDigits_WhenToManyDigits() {

        String customerInput = "54478987858522222222";
        List<String> errorsList = cardValidator.validate(customerInput);
        String[] actual = errorsList.stream().toArray(String[]::new);
        String[] expected = {"too many digits in card number"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validate_ShouldReturn3ErrorMessages_WhenWrongSystemIdentifierTooManyDigitsAlphanumerics() {

        String customerInput = "A784-8989-8888-8787-7777";
        List<String> errorsList = cardValidator.validate(customerInput);
        String[] actual = errorsList.stream().toArray(String[]::new);
        String[] expected = {"wrong card number \n card number should starts within 2 - 6",
                "too many digits in card number", "you have entered not a numeric digits"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validate_ShouldReturn1ErrorMessage_WhenWrongPaymentSystemId() {

        String customerInput = "9784545454545454";
        List<String> errorsList = cardValidator.validate(customerInput);
        String[] actual = errorsList.stream().toArray(String[]::new);
        String[] expected = {"wrong card number \n card number should starts within 2 - 6"};
        assertArrayEquals(expected, actual);
    }
}