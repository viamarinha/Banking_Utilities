package dev.andrylat.bankingutilities.mortgagecalculator.mortgagedialog;

import dev.andrylat.bankingutilities.mortgagecalculator.mortgagepayment.MortgagePayment;

public interface MortgageDialog {

    void setMortgagePayments(MortgagePayment mortgagePayment);

    public double[] customerPaymentMenu();

    void showResult();
}
