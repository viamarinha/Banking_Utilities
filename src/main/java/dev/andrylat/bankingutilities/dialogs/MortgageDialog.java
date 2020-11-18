package dev.andrylat.bankingutilities.dialogs;

import dev.andrylat.bankingutilities.mortgagecalculator.CustomerData;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePayment;

public interface MortgageDialog {

    void setMortgagePayments(MortgagePayment mortgagePayment);

    public CustomerData customerPaymentMenu();

    void showResult();
}
