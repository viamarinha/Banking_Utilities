package dev.andrylat.bankingutilities.mortgagecalculator;

public interface MortgagePayment {

    void setDetailsForCalculation(CustomerData customerData);

    void paymentCalculation();

    String toString();

   }
