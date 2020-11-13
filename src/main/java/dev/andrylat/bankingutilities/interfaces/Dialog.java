package dev.andrylat.bankingutilities.interfaces;

import java.util.List;

public interface Dialog {

    String getCustomerData();

    <K> void showErrorsLog(List<K> errorResult);

    List<String> validateCustomerInput(String customerInput);

    void setBankingCardValidator(CardValidator bankingCardValidator);

    void showCardType();

    void setCardTypeValidator(CardTypeValidator cardTypeValidator);

    double[] customerPaymentMenu();

    void setMortgagePayment(MortgagePayment mortgagePayment);

    void showMortgagePayment();

}
