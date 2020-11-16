package dev.andrylat.bankingutilities.mortgagecalculator.mortgagepayment;

public interface MortgagePayment {

    void setDetailsForCalculation(double[] detailsForCalculation);

    void paymentCalculation();

    String toString();

   }
