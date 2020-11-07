package andrylat.bankingutilities.dev.validators;

import andrylat.bankingutilities.dev.interfaces.ValidatorInt;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BankingCardValidator implements ValidatorInt {

    private Map<String, String> resultValidator = new HashMap();

    public Map<String, String> interactionWithCustomer(String[] customerInput) {

        String customerCardNumber = customerInput[0];
        String customerControlNumber = customerInput[1];
        String cardRegex = "([2-6]([0-9]{3})(\\s|-)?)(([0-9]{4}(\\s|-)?){3})";
        String cvvRegex = "[\\d]{3}";

        Pattern cardNumberPattern = Pattern.compile(cardRegex);
        Pattern controlNumberPattern = Pattern.compile(cvvRegex);

        Matcher cardMatcher = cardNumberPattern.matcher(customerCardNumber);
        Matcher controlNumberMatcher = controlNumberPattern.matcher(customerControlNumber);

        if (cardMatcher.matches() && controlNumberMatcher.matches()) {
            resultValidator.put("ok", "ok");
            return resultValidator;
        } else {
            if (!cardMatcher.matches()) {
                resultValidator.put("Card number problem : ", "wrong card number \n card number should starts within 2 - 6");
            }
            String cleanCustomerInput = customerCardNumber.replaceAll("[\\s-]", "");
            if (cleanCustomerInput.length() < 16)
                resultValidator.put("Card number problem : ", "not enough digits in card number");
            if (cleanCustomerInput.length() > 16)
                resultValidator.put("Card number problem : ", "too many digits in card number");
            if (!cleanCustomerInput.matches("[0-9]+"))
                resultValidator.put("Card number problem :", "you have entered not a numeric digits");
            if (!customerControlNumber.matches("[\\d]" +
                    "{3}"))
                resultValidator.put("Cvv problem :", "Cvv incorrect");
        }
        return resultValidator;

    }

}
