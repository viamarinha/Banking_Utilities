package dev.andrylat.bankingutilities.dialogs;

import dev.andrylat.bankingutilities.card.validators.CardValidator;

import java.util.List;

public interface BankingSystemDialog {

    String getCustomerData();

    <K> void showErrorsLog(List<K> errorResult);

    List<String> validateCustomerInput(String customerInput);

    void setBankingCardValidator(CardValidator cardValidator);

    void showCardType();

}
