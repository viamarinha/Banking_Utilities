package dev.andrylat.dialogs.impl;

import dev.adrylat.bankingfunctionality.card.PaymentSystem;
import dev.adrylat.bankingfunctionality.card.exceptions.CardValidatorException;
import dev.adrylat.bankingfunctionality.card.validators.CardValidator;
import dev.andrylat.dialogs.Dialog;
import java.util.Scanner;

public class BankingDialog implements Dialog {

    private int paymentCompanyIdentifier;
    private CardValidator cardValidator;

    public BankingDialog(CardValidator cardValidator) {
        this.cardValidator = cardValidator;
    }

    @Override
    public void start() {
        String customerData = getCustomerData();
        try {
            if (validateCustomerInput(customerData)) {
                setPaymentCompanyIdentifier(customerData);
                showCardType();
            }
        } catch (CardValidatorException exception) {
           System.err.println(exception.getErrorList());
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

    private boolean validateCustomerInput(String customerInput) throws CardValidatorException {

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
