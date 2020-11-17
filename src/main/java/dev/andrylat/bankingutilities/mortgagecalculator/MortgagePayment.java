package dev.andrylat.bankingutilities.mortgagecalculator;

public interface MortgagePayment {

    void setDetailsForCalculation(double[] detailsForCalculation);

    void paymentCalculation();

    String toString();

   }
