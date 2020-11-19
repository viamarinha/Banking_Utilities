package dev.andrylat.bankingutilities.dialogs.impl;

import dev.andrylat.bankingutilities.card.validators.CardValidator;
import dev.andrylat.bankingutilities.dialogs.BankingSystemDialog;

import java.util.List;
import java.util.Scanner;

public class BankingSystemDialogImpl implements BankingSystemDialog {

    private CardValidator cardValidator;


    @Override
    public void setBankingCardValidator(CardValidator validatorInt) {
        this.cardValidator = validatorInt;
    }

    @Override
    public String getCustomerData() {

        System.out.println("Enter a card number with 16 digits");
        System.out.println("Ex : xxxx-xxxx-xxxx-xxxx or \n xxxx xxxx xxxx xxxx");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public <K> void showErrorsLog(List<K> errorResult) {
        errorResult.forEach(System.out::println);
    }

    @Override
    public List<String> validateCustomerInput(String customerInput) {
        return cardValidator.validate(customerInput);
    }

    @Override
    public void showCardType() {
        if (cardValidator.customerCardType() != null) {
            System.out.println("Your payment system is  " + cardValidator.customerCardType());
        } else {
            System.out.println("Your payment system is doesn't exist " + cardValidator.customerCardType());
        }
    }
}
