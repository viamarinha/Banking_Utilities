package dev.andrylat.bankingutilities.dialogs.impl;

import dev.andrylat.bankingutilities.dialogs.MortgageDialog;
import dev.andrylat.bankingutilities.mortgagecalculator.CustomerData;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePayment;
import java.util.Scanner;

public class MortgageDialogImpl implements MortgageDialog {

    private MortgagePayment mortgagePayment;

    @Override
    public void setMortgagePayments(MortgagePayment mortgagePayment) {
        this.mortgagePayment = mortgagePayment;
    }

    @Override
    public CustomerData customerPaymentMenu() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Principal Amount : ");
        double principalAmount = scan.nextDouble();

        System.out.print("Enter Rate of Interest : ");
        double interestRate = scan.nextDouble();

        System.out.print("Enter Time period in years : ");
        double yearsPeriod = scan.nextDouble();

        System.out.println("Please select payment period : " +
                "\n For Year payment press 1 " +
                "\n For Monthly payment press 2  " +
                "\n For Weekly period press 3 ");
        double periodChoice = scan.nextDouble();

        return new CustomerData(principalAmount, interestRate, yearsPeriod, periodChoice);
    }

    public void showResult(){
        System.out.println(mortgagePayment.toString());
    }
}
