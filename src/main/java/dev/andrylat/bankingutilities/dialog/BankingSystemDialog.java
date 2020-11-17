package dev.andrylat.bankingutilities.dialog;

import dev.andrylat.bankingutilities.cardvalidator.validators.CardValidator;
import dev.andrylat.bankingutilities.cardvalidator.validators.PaymentValidator;

import java.util.List;

public interface BankingSystemDialog extends Dialog{

    String getCustomerData();

    <K> void showErrorsLog(List<K> errorResult);

    List<String> validateCustomerInput(String customerInput);

    void setBankingCardValidator(CardValidator bankingCardValidator);

    void showCardType();

    void setCardTypeValidator(PaymentValidator paymentValidator);



}
