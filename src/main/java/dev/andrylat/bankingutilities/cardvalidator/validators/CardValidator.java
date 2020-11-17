package dev.andrylat.bankingutilities.cardvalidator.validators;

import java.util.List;

public interface CardValidator {
     List<String> validate(String customerInput);
}
