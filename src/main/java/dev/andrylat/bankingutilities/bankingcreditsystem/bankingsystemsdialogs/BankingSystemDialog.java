package dev.andrylat.bankingutilities.bankingcreditsystem.bankingsystemsdialogs;

import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsysteminterfaces.PaymentValidator;
import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsysteminterfaces.CardValidator;

import java.util.List;

public interface BankingSystemDialog {

    String getCustomerData();

    <K> void showErrorsLog(List<K> errorResult);

    List<String> validateCustomerInput(String customerInput);

    void setBankingCardValidator(CardValidator bankingCardValidator);

    void showCardType();

    void setCardTypeValidator(PaymentValidator paymentValidator);



}
