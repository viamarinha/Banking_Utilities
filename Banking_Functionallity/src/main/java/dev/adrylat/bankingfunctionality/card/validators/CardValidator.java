package dev.adrylat.bankingfunctionality.card.validators;

import dev.adrylat.bankingfunctionality.card.MyException;

public interface CardValidator {

   boolean validate(String customerInput) throws MyException;
}
