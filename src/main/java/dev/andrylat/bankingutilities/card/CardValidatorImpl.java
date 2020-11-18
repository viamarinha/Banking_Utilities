package dev.andrylat.bankingutilities.card;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidatorImpl implements CardValidator {

    private static final String CARD_REGEX = "([2-6]([0-9]{3})(\\s|-)?)(([0-9]{4}(\\s|-)?){3})";
    private static final String NUMERIC_DIGITS = "[0-9]+";
    private static final String SPACE_DASH_REGEX = "[\\s-]";
    private static final int CREDIT_CARD_NUMBER_SIZE = 16;
    private static final int MAX_DIGIT_VALUE = 9;
    private static final Pattern CARD_NUMBER_PATTERN = Pattern.compile(CARD_REGEX);
    private List<String> validationMessages = new LinkedList<>();

    public List<String> validate(String customerInput) {

        Matcher cardMatcher = CARD_NUMBER_PATTERN.matcher(customerInput);
        if (cardMatcher.matches()) {
            if (validateControlNumber(customerInput)) {
                return validationMessages;
            }
        } else {
            cardsErrorsTreatments(customerInput, cardMatcher);
        }
        return validationMessages;
    }

    private void cardsErrorsTreatments(String customerInput, Matcher cardMatcher) {

        String cleanCustomerInput = format(customerInput);
        if (!cardMatcher.matches()) {
            List<Integer> validFirstChar = Arrays.asList(2, 3, 4, 5, 6);
            int firstChar = Character.getNumericValue(customerInput.toCharArray()[0]);

            if (!validFirstChar.contains(firstChar))
                validationMessages.add("wrong card number \n card number should starts within 2 - 6");
        }
        if (cleanCustomerInput.length() < CREDIT_CARD_NUMBER_SIZE)
            validationMessages.add("not enough digits in card number");

        if (cleanCustomerInput.length() > CREDIT_CARD_NUMBER_SIZE)
            validationMessages.add("too many digits in card number");

        if (!cleanCustomerInput.matches(NUMERIC_DIGITS))
            validationMessages.add("you have entered not a numeric digits");
    }

    private boolean validateControlNumber(String customerInput) {

        String cleanCustomerInput = format(customerInput);
        List<Integer> creditCardInt = new LinkedList<>();

        for (int i = 0; i < cleanCustomerInput.length(); i++) {
            creditCardInt.add(Integer.parseInt(cleanCustomerInput.substring(i, i + 1)));
        }

        for (int count = creditCardInt.size() - 2; count >= 0; count -= 2) {
            int tmpValue = creditCardInt.get(count);
            tmpValue *= 2;
            if (tmpValue > MAX_DIGIT_VALUE)
                tmpValue = tmpValue % 10 + 1;
            creditCardInt.set(count, tmpValue);
        }

        int sumAllDigits = creditCardInt.stream().mapToInt(Integer::intValue).sum();

        if (sumAllDigits % 10 == 0) {
            return true;
        } else {
            validationMessages.add("incorrect control number");
            return false;
        }
    }

    private String format(String customerInput) {
        return customerInput.replaceAll(SPACE_DASH_REGEX, "");
    }

}
