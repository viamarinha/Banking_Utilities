package dev.andrylat.bankingutilities.mortgagecalculator;

public interface MortgagePayment {

    void setMortgageDetails(CustomerData customerData);

    void paymentCalculation();

    double getPayment();

}
