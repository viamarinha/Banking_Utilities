package dev.andrylat.bankingutilities.cardvalidator.systemchoicevalidators;

import dev.andrylat.bankingutilities.cardvalidator.validators.InitialSystemValidator;
import dev.andrylat.bankingutilities.cardvalidator.validators.InitialSystemValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class InitialSystemValidatorImplTest {

    private InitialSystemValidator initialSystemValidator;

    @BeforeEach
    void setUp() {

        initialSystemValidator = new InitialSystemValidatorImpl();
        String SYSTEM_CHOICE_REGEX = "[1-2]";
        Pattern SYSTEM_PATTERN = Pattern.compile(SYSTEM_CHOICE_REGEX);
    }

    @Test
    void validateCustomerChoice_shouldReturnTrue_whenChoiceIs1() {
        String customerSystemChoice = "1";
        boolean expected = initialSystemValidator.validateCustomerChoice(customerSystemChoice);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerChoice_shouldReturnTrue_whenChoiceIs2() {
        String customerSystemChoice = "2";
        boolean expected = initialSystemValidator.validateCustomerChoice(customerSystemChoice);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerChoice_shouldReturnFalse_whenChoiceIsInvalid() {
        String customerSystemChoice = "b";
        boolean expected = initialSystemValidator.validateCustomerChoice(customerSystemChoice);
        boolean actual = false;
        assertEquals(expected, actual);
    }

}