package dev.andrylat.bankingutilities.dialog;

import dev.andrylat.bankingutilities.interfaces.CardTypeValidator;
import dev.andrylat.bankingutilities.interfaces.Dialog;
import dev.andrylat.bankingutilities.interfaces.CardValidator;
import dev.andrylat.bankingutilities.interfaces.MortgagePayment;

import java.util.List;
import java.util.Scanner;

public class ProgressDialog implements Dialog {

    private CardValidator validatorInt;
    private MortgagePayment mortgagePayment;
    private CardTypeValidator cardTypeValidator;

    @Override
    public void setMortgagePayment(MortgagePayment mortgagePayment) {
        this.mortgagePayment = mortgagePayment;
    }

    @Override
    public void setBankingCardValidator(CardValidator validatorInt) {
        this.validatorInt = validatorInt;
    }

    @Override
    public void setCardTypeValidator(CardTypeValidator cardTypeValidator){
        this.cardTypeValidator = cardTypeValidator;
    }

    @Override
    public String getCustomerData() {
        System.out.println("Enter a card number with 16 digits");
        System.out.println("Ex : xxxx-xxxx-xxxx-xxxx or \n xxxx xxxx xxxx xxxx");
        Scanner scanner = new Scanner(System.in);
        String customerCardNumber = scanner.nextLine();

        return customerCardNumber;
    }

    @Override
    public <K> void showErrorsLog(List<K> errorResult) {
        errorResult.forEach(System.out::println);
    }

    @Override
    public List<String> validateCustomerInput(String customerInput) {
        return validatorInt.validate(customerInput);
    }

    @Override
    public void showCardType() {
        System.out.println("Your payment system is  " + cardTypeValidator.customerCardType());
    }

    @Override
    public double[] customerPaymentMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Principal Amount : ");
        double principal_Amount = scan.nextDouble();
        System.out.print("Enter Rate of Interest : ");
        double interestRate = scan.nextDouble();
        System.out.print("Enter Time period in years : ");
        double yearsPeriod = scan.nextInt();

        return new double[]{principal_Amount, interestRate, yearsPeriod};
    }
    @Override
    public void showMortgagePayment() {
        System.out.println(mortgagePayment.toString());
    }
}
