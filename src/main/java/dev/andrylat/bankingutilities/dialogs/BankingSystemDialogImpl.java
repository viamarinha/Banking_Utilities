package dev.andrylat.bankingutilities.dialogs;

import dev.andrylat.bankingutilities.card.CardValidator;
import dev.andrylat.bankingutilities.card.PaymentValidator;

import java.util.List;
import java.util.Scanner;

public class BankingSystemDialogImpl implements BankingSystemDialog {

    private CardValidator validatorInt;
    private PaymentValidator paymentValidator;

    @Override
    public void setBankingCardValidator(CardValidator validatorInt) {
        this.validatorInt = validatorInt;
    }

    @Override
    public void setCardTypeValidator(PaymentValidator paymentValidator) {
        this.paymentValidator = paymentValidator;
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
        return validatorInt.validate(customerInput);
    }

    @Override
    public void showCardType() {
        if (paymentValidator.customerCardType() != null) {
            System.out.println("Your payment system is  " + paymentValidator.customerCardType());
        } else {
            System.out.println("Your payment system is doesn't exist " + paymentValidator.customerCardType());
        }
    }
}
