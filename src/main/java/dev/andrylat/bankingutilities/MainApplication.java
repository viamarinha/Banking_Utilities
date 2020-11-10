package dev.andrylat.bankingutilities;

import dev.andrylat.bankingutilities.dialog.ProgressDialog;
import dev.andrylat.bankingutilities.interfaces.Dialog;
import dev.andrylat.bankingutilities.interfaces.ValidatorInt;
import dev.andrylat.bankingutilities.validators.BankingCardValidator;

import java.util.Map;

public class MainApplication {

    public static void main(String[] args) {
        initMainApplication();
    }

    private static void initMainApplication() {

        Dialog progressDialog = new ProgressDialog();
        ValidatorInt bankingCardValidator = new BankingCardValidator();
        progressDialog.setCustomerInteraction(bankingCardValidator);

        String customerCardNumber = progressDialog.getCustomerData();

        Map<String, String> errorResult = progressDialog.interactionWithCustomer(customerCardNumber);
        if (errorResult.entrySet().stream().findFirst().get().getValue().equalsIgnoreCase("ok"))
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
