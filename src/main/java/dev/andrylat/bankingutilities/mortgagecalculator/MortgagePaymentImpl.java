package dev.andrylat.bankingutilities.mortgagecalculator;


import java.text.DecimalFormat;

public class MortgagePaymentImpl implements MortgagePayment {
    private static final int YEAR = 1;
    private static final int MONTH = 2;
    private static final int WEEK = 3;
    private double principalAmount;
    private double interestRate;
    private double yearsPeriod;
    private double payment;
    private double[] detailsForCalculation;

    public void setDetailsForCalculation(double[] detailsForCalculation) {
        this.detailsForCalculation = detailsForCalculation;
    }

    @Override
    public void paymentCalculation() {
        try {
            double periodChose = detailsForCalculation[3];
            if (periodChose == YEAR) {
                yearlyPaymentCalculation();
            } else if (periodChose == MONTH) {
                monthlyPaymentCalculation();
            } else if (periodChose == WEEK) {
                weeklyPaymentCalculation();
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private void weeklyPaymentCalculation() {
        setUpCalculationDetails(detailsForCalculation);
        interestRate = (interestRate / 100) / 52;
        double weekPeriods   = yearsPeriod * 52;
        payment = (principalAmount * interestRate) / (1 - Math.pow(1 + interestRate, -weekPeriods));
        payment = Math.round(payment * 100) / 100;
    }

    private void yearlyPaymentCalculation() {
        setUpCalculationDetails(detailsForCalculation);
        interestRate = (interestRate / 100) ;
        payment = Math.round(((principalAmount * interestRate) / (1 - Math.pow(1 + interestRate, -yearsPeriod))) * 100) / 100;
    }

    private void monthlyPaymentCalculation() {
        setUpCalculationDetails(detailsForCalculation);
        interestRate = (interestRate / 100) / 12;
        double monthPeriods = yearsPeriod * 12;
        payment = (principalAmount * interestRate) / (1 - Math.pow(1 + interestRate, -monthPeriods));

        payment = Double.parseDouble(new DecimalFormat("######.##").format(payment));
    }

    private void setUpCalculationDetails(double[] detailsForCalculation) {
        principalAmount = detailsForCalculation[0];
        interestRate = detailsForCalculation[1];
        yearsPeriod = detailsForCalculation[2];
    }

    @Override
    public String toString() {
        return "Your Payment is " + payment;
    }

}
