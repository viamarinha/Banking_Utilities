package dev.adrylat.bankingfunctionality.mortgagecalculator;

public interface MortgagePayment {

    void setMortgageDetails(CustomerData customerData);

    void paymentCalculation();

    double getPayment();

}
