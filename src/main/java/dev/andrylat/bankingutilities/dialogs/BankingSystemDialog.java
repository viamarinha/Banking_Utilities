package dev.andrylat.bankingutilities.dialogs;

import dev.andrylat.bankingutilities.card.CardValidator;
import dev.andrylat.bankingutilities.card.PaymentValidator;

import java.util.List;

public interface BankingSystemDialog {

    String getCustomerData();

    <K> void showErrorsLog(List<K> errorResult);

    List<String> validateCustomerInput(String customerInput);

    void setBankingCardValidator(CardValidator bankingCardValidator);

    void showCardType();

    void setCardTypeValidator(PaymentValidator paymentValidator);
}
