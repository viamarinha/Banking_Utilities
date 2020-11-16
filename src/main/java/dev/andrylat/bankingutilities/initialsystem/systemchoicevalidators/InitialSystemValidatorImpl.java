package dev.andrylat.bankingutilities.initialsystem.systemchoicevalidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitialSystemValidatorImpl implements InitialSystemValidator {

    private static final String SYSTEM_CHOICE_REGEX = "[1-2]";
    private static final Pattern SYSTEM_PATTERN = Pattern.compile(SYSTEM_CHOICE_REGEX);
    ;


    @Override
    public boolean validateCustomerChoice(String customerSystemChoice) {
        Matcher systemMatcher = SYSTEM_PATTERN.matcher(customerSystemChoice);
        return (systemMatcher.matches());

    }
}
