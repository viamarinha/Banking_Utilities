package dev.andrylat.bankingutilities.mortgagecalculator;


import java.text.DecimalFormat;

public class MortgagePaymentImpl implements MortgagePayment {
    private static final int YEAR = 1;
    private static final int MONTH = 2;
    private static final int WEEK = 3;
    private static final int YEAR_WEEKS_VALUE = 52;
    private static final int YEAR_MONTH_VALUE = 12;
    private static final String DOUBLE_VALUE = "######.##";
    private double principalAmount;
    private double interestRate;
    private double yearsPeriod;
    private double payment;
    private CustomerData customerData;

    public void setMortgageDetails(CustomerData customerData) {
        this.customerData = customerData;
    }

    public double getPayment() {
        return this.payment;
    }

    @Override
    public void paymentCalculation() {

        double periodChose = customerData.getPeriodChoice();
        if (periodChose == YEAR) {
            yearlyPaymentCalculation();
        } else if (periodChose == MONTH) {
            monthlyPaymentCalculation();
        } else if (periodChose == WEEK) {
            weeklyPaymentCalculation();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void weeklyPaymentCalculation() {
        setUpCalculationDetails(customerData);
        interestRate = (interestRate / 100) / YEAR_WEEKS_VALUE;
        double weekPeriods = yearsPeriod * YEAR_WEEKS_VALUE;
        payment = (principalAmount * interestRate) / (1 - Math.pow(1 + interestRate, -weekPeriods));
        payment = Double.parseDouble(new DecimalFormat(DOUBLE_VALUE).format(payment));
    }

    private void yearlyPaymentCalculation() {
        setUpCalculationDetails(customerData);
        interestRate = (interestRate / 100);
        payment = (principalAmount * interestRate) / (1 - Math.pow(1 + interestRate, -yearsPeriod));
        payment = Double.parseDouble(new DecimalFormat(DOUBLE_VALUE).format(payment));
    }

    private void monthlyPaymentCalculation() {
        setUpCalculationDetails(customerData);
        interestRate = (interestRate / 100) / YEAR_MONTH_VALUE;
        double monthPeriods = yearsPeriod * YEAR_MONTH_VALUE;
        payment = (principalAmount * interestRate) / (1 - Math.pow(1 + interestRate, -monthPeriods));
        payment = Double.parseDouble(new DecimalFormat(DOUBLE_VALUE).format(payment));
    }

    private void setUpCalculationDetails(CustomerData customerData) {
        principalAmount = customerData.getPrincipalAmount();
        interestRate = customerData.getInterestRate();
        yearsPeriod = customerData.getYearsPeriod();
    }


}
