package dev.andrylat.bankingutilities.validators;

import dev.andrylat.bankingutilities.interfaces.ValidatorInt;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankingCardValidator implements ValidatorInt {

    private final Map<String, String> resultValidator = new HashMap<>();
    private final String cardRegex = "([2-6]([0-9]{3})(\\s|-)?)(([0-9]{4}(\\s|-)?){3})";
    private final String numericDigits = "[0-9]+";
    private String cleanCustomerInput;

    public Map<String, String> interactionWithCustomer(String customerInput) {

        Pattern cardNumberPattern = Pattern.compile(cardRegex);
        Matcher cardMatcher = cardNumberPattern.matcher(customerInput);
        cleanCustomerInput = cleanCustomerInput(customerInput);
        if (cardMatcher.matches()) {
            if (validateControlNumber(customerInput)) {
                resultValidator.put("ok", "ok");
                return resultValidator;
            }

        } else {
            cardsErrorsTreatments(customerInput, cardMatcher);
        }
        return resultValidator;
    }

    private void cardsErrorsTreatments(String customerInput, Matcher cardMatcher) {

        if (!cardMatcher.matches()) {
            List<Integer> validFirstChar = Arrays.asList(2, 3, 4, 5, 6);
            int firstChar = Character.getNumericValue(customerInput.toCharArray()[0]);
            if (!validFirstChar.contains(firstChar))
                resultValidator.put("Card number problem : ", "wrong card number \n card number should starts within 2 - 6");
        }
        if (cleanCustomerInput.length() < 16)
            resultValidator.put("Card number problem : ", "not enough digits in card number");
        if (cleanCustomerInput.length() > 16)
            resultValidator.put("Card number problem : ", "too many digits in card number");
        if (!cleanCustomerInput.matches(numericDigits))
            resultValidator.put("Card number problem :", "you have entered not a numeric digits");
    }

    private boolean validateControlNumber(String customerInput) {

        List<Integer> creditCardInt = new LinkedList<>();


        for (int i = 0; i < cleanCustomerInput.length(); i++) {
            creditCardInt.add(Integer.parseInt(cleanCustomerInput.substring(i, i + 1)));
        }

        for (int count = creditCardInt.size() - 2; count >= 0; count -= 2) {
            int tmpValue = creditCardInt.get(count);
            tmpValue *= 2;
            if (tmpValue > 9)
                tmpValue = tmpValue % 10 + 1;
            creditCardInt.set(count, tmpValue);
        }

        int lstSum = creditCardInt.stream().mapToInt(Integer::intValue).sum();

        if (lstSum % 10 == 0) {
            return true;
        } else {
            resultValidator.put("Card number problem :", "incorrect control number");
            return false;
        }
    }

    public String cleanCustomerInput(String customerInput) {
        String cleanCustomerInput = customerInput.replaceAll("[\\s-]", "");
        return cleanCustomerInput;
    }

}
