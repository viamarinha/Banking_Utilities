package dev.andrylat.bankingutilities.dialogs.impl;

import dev.andrylat.bankingutilities.card.PaymentSystem;
import dev.andrylat.bankingutilities.card.validators.CardValidator;
import dev.andrylat.bankingutilities.dialogs.Dialog;

import java.util.List;
import java.util.Scanner;

public class BankingDialog implements Dialog {

    private int paymentCompanyIdentifier;
    private CardValidator cardValidator;
    private String customerData;

    public BankingDialog(CardValidator cardValidator) {
        this.cardValidator = cardValidator;
    }

    @Override
    public void start() {
        customerData = getCustomerData();

        List<String> errorResult = validateCustomerInput(customerData);
        if (errorResult.isEmpty()) {
            setPaymentCompanyIdentifier(customerData);
            showCardType();
        } else {
            showErrorsLog(errorResult);
            errorResult.clear();
            start();
        }
    }

    public void setPaymentCompanyIdentifier(String customerData) {
        this.paymentCompanyIdentifier = Integer.parseInt(String.valueOf(customerData.toCharArray()[0]));
    }

    public String getCustomerData() {

        System.out.println("Enter a card number with 16 digits");
        System.out.println("Ex : xxxx-xxxx-xxxx-xxxx or \n xxxx xxxx xxxx xxxx");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public <K> void showErrorsLog(List<K> errorResult) {
        errorResult.forEach(System.err::println);
    }

    public List<String> validateCustomerInput(String customerInput) {
        return cardValidator.validate(customerInput);
    }

    public void showCardType() {
        if (customerCardType() != null) {
            System.out.println("Your payment system is  " + customerCardType() + "\n");
        } else {
            System.err.println("Your payment system  doesn't exist " + customerCardType());
        }
    }

    private String customerCardType() {
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(paymentCompanyIdentifier);
        if (paymentSystem != null) {
            return paymentSystem.getPaymentType();
        } else {
            return null;
        }
    }
}
