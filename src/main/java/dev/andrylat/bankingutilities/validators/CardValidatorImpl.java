package dev.andrylat.bankingutilities.validators;

import dev.andrylat.bankingutilities.interfaces.CardValidator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidatorImpl implements CardValidator {

    private static final String cardRegex = "([2-6]([0-9]{3})(\\s|-)?)(([0-9]{4}(\\s|-)?){3})";
    private static final String numericDigits = "[0-9]+";
    private static final String spaceDashRegex = "[\\s-]";
    private static final int cardSize = 16;
    private static final int maxDigitValue = 9;
    private final List<String> resultValidator = new ArrayList<>();

    public List<String> interactionWithCustomer(String customerInput) {

        Pattern cardNumberPattern = Pattern.compile(cardRegex);
        Matcher cardMatcher = cardNumberPattern.matcher(customerInput);
        if (cardMatcher.matches()) {
            if (validateControlNumber(customerInput)) {
                resultValidator.add("ok");
                return resultValidator;
            }
        } else {
            cardsErrorsTreatments(customerInput, cardMatcher);
        }
        return resultValidator;
    }

    private void cardsErrorsTreatments(String customerInput, Matcher cardMatcher) {

        String cleanCustomerInput = format(customerInput);
        if (!cardMatcher.matches()) {
            List<Integer> validFirstChar = Arrays.asList(2, 3, 4, 5, 6);
            int firstChar = Character.getNumericValue(customerInput.toCharArray()[0]);
            if (!validFirstChar.contains(firstChar))
                resultValidator.add("wrong card number \n card number should starts within 2 - 6");
        }
        if (cleanCustomerInput.length() < cardSize)
            resultValidator.add("not enough digits in card number");
        if (cleanCustomerInput.length() > cardSize)
            resultValidator.add("too many digits in card number");
        if (!cleanCustomerInput.matches(numericDigits))
            resultValidator.add("you have entered not a numeric digits");
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
            if (tmpValue > maxDigitValue)
                tmpValue = tmpValue % 10 + 1;
            creditCardInt.set(count, tmpValue);
        }

        int SumAllDigits = creditCardInt.stream().mapToInt(Integer::intValue).sum();

        if (SumAllDigits % 10 == 0) {
            return true;
        } else {
            resultValidator.add("incorrect control number");
            return false;
        }
    }

    private String format(String customerInput) {
        String cleanCustomerInput = customerInput.replaceAll(spaceDashRegex, "");
        return cleanCustomerInput;
    }

}
