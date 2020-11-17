package dev.andrylat.bankingutilities.cardvalidator.validators;

import dev.andrylat.bankingutilities.dialog.Dialog;

public interface InitialSystemValidator extends Dialog {

    boolean validateCustomerChoice(String customerSystemChoice);
}
