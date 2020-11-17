package dev.andrylat.bankingutilities.dialog;

import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePayment;

public interface MortgageDialog extends Dialog{

    void setMortgagePayments(MortgagePayment mortgagePayment);

    public double[] customerPaymentMenu();

    void showResult();
}
