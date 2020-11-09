package andrylat.bankingutilities.dev.mainapplication;

import andrylat.bankingutilities.dev.dialog.ProgressDialog;
import andrylat.bankingutilities.dev.interfaces.Dialog;
import andrylat.bankingutilities.dev.interfaces.ValidatorInt;
import andrylat.bankingutilities.dev.validators.BankingCardValidator;

import java.util.Map;

public class MainApplication {

    public static void main(String[] args) {
        reRun();
    }

    private static void reRun() {

        Dialog progressDialog = new ProgressDialog();
        ValidatorInt bankingCardValidator = new BankingCardValidator();
        progressDialog.setCustomerInteraction(bankingCardValidator);

        String[] customerCardNumber = progressDialog.getCustomerData();

        Map<String, String> errorResult = progressDialog.interactionWithCustomer(customerCardNumber);
        if (errorResult.entrySet().stream().findFirst().get().getValue().equalsIgnoreCase("ok"))
            paymentSystem();
        else {
            progressDialog.showErrorsLog(errorResult);
            reRun();
        }
    }

    private static void paymentSystem() {
        System.out.println("You are in main apps");
    }


}
