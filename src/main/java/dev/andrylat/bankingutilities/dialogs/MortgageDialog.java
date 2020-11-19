package dev.andrylat.bankingutilities.dialogs;

import dev.andrylat.bankingutilities.mortgagecalculator.CustomerData;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePayment;

public interface MortgageDialog {

    void setMortgagePayments(MortgagePayment mortgagePayment);

    CustomerData customerPaymentMenu();

    void showResult();
}
