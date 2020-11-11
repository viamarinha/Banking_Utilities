package dev.andrylat.bankingutilities.dialog;

import dev.andrylat.bankingutilities.interfaces.Dialog;
import dev.andrylat.bankingutilities.interfaces.CardValidator;

import java.util.List;
import java.util.Scanner;

public class ProgressDialog implements Dialog {

    private CardValidator validatorInt;


    public void setCustomerInteraction(CardValidator validatorInt)  {
        this.validatorInt = validatorInt;
    }

    public  String getCustomerData() {
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

    public List<String> interactionWithCustomer(String customerInput) {
        return validatorInt.customerDataTreatment(customerInput);
    }
}
