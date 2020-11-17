package dev.andrylat.bankingutilities.dialog;

import dev.andrylat.bankingutilities.cardvalidator.validators.InitialSystemValidator;

public interface InitialDialog extends Dialog{

    void setInitialSystemValidator(InitialSystemValidator initialSystemValidator);

}
