package dev.andrylat.bankingutilities;

import dev.andrylat.bankingutilities.dialog.ProgressDialog;
import dev.andrylat.bankingutilities.interfaces.Dialog;
import dev.andrylat.bankingutilities.interfaces.CardValidator;
import dev.andrylat.bankingutilities.validators.CardValidatorImpl;

import java.util.List;
import java.util.Map;

public class MainApplication {

    public static void main(String[] args) {
        initMainApplication();
    }

    private static void initMainApplication() {

        Dialog progressDialog = new ProgressDialog();
        CardValidator bankingCardValidator = new CardValidatorImpl();
        progressDialog.setCustomerInteraction(bankingCardValidator);

        String customerCardNumber = progressDialog.getCustomerData();

        List<String> errorResult = progressDialog.interactionWithCustomer(customerCardNumber);
        if (errorResult.stream().findFirst().get().equalsIgnoreCase("ok"))
            paymentSystem();
        else {
            progressDialog.showErrorsLog(errorResult);
            initMainApplication();
        }
    }

    private static void paymentSystem() {
        System.out.println("You are in main apps");
    }


}
