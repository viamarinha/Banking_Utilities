package dev.adrylat.bankingfunctionality.mortgagecalculator;

public class CustomerData {

    private double principalAmount;
    private double interestRate;
    private double yearsPeriod;
    private double periodChoice;

    public CustomerData(double principalAmount, double interestRate, double yearsPeriod, double periodChoice) {
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.yearsPeriod = yearsPeriod;
        this.periodChoice = periodChoice;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getYearsPeriod() {
        return yearsPeriod;
    }

    public double getPeriodChoice() {
        return periodChoice;
    }
}
