package dev.adrylat.bankingfunctionality.card.validators;

import dev.adrylat.bankingfunctionality.card.exceptions.CardValidatorException;

public interface CardValidator {

   boolean validate(String input) throws CardValidatorException;
}
