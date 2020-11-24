package dev.andrylat.bankingutilities.dialogs.impl;

import dev.andrylat.bankingutilities.dialogs.Dialog;
import dev.andrylat.bankingutilities.mortgagecalculator.CustomerData;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePayment;

import java.util.Scanner;

public class MortgageDialog implements Dialog {

    private MortgagePayment mortgagePayment;

    public MortgageDialog(MortgagePayment mortgagePayment) {
        this.mortgagePayment = mortgagePayment;
    }

    @Override
    public void start() {
        mortgagePayment.setMortgageDetails(showCustomerPaymentMenu());
        mortgagePayment.paymentCalculation();
        showPayment(mortgagePayment.getPayment());
    }

    private void showPayment(double payment) {
        System.out.println("Your payment is : " + payment + " $ \n");
    }

    private CustomerData showCustomerPaymentMenu() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Principal Amount : ");
        double principalAmount = scan.nextDouble();

        System.out.print("Enter Rate of Interest : ");
        double interestRate = scan.nextDouble();

        System.out.print("Enter Time period in years : ");
        double yearsPeriod = scan.nextDouble();

        System.out.println("\n Please select payment period : " +
                "\n For Year payment press 1 " +
                "\n For Monthly payment press 2  " +
                "\n For Weekly period press 3 ");
        double periodChoice = scan.nextDouble();

        if (principalAmount <= 0 || interestRate <= 0 || yearsPeriod <= 0 || periodChoice <= 0) {
            System.err.println("You have entered wrong calculation data , please make your choice ");
            showCustomerPaymentMenu();
        }
        return new CustomerData(principalAmount, interestRate, yearsPeriod, periodChoice);
    }


}
