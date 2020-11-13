package dev.andrylat.bankingutilities;

import dev.andrylat.bankingutilities.Enumerations.BankingCardType;
import dev.andrylat.bankingutilities.dialog.ProgressDialog;
import dev.andrylat.bankingutilities.interfaces.CardTypeValidator;
import dev.andrylat.bankingutilities.interfaces.Dialog;
import dev.andrylat.bankingutilities.interfaces.CardValidator;
import dev.andrylat.bankingutilities.interfaces.MortgagePayment;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePaymentImpl;
import dev.andrylat.bankingutilities.validators.CardTypeValidatorImpl;
import dev.andrylat.bankingutilities.validators.CardValidatorImpl;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        initMainApplication();
    }

    private static void initMainApplication() {

        Dialog progressDialog = new ProgressDialog();
        CardValidator bankingCardValidator = new CardValidatorImpl();
        progressDialog.setBankingCardValidator(bankingCardValidator);
        String customerCardNumber = progressDialog.getCustomerData();

        List<String> errorResult = progressDialog.validateCustomerInput(customerCardNumber);
        if (errorResult.stream().findFirst().get().equalsIgnoreCase("ok")) {
            showPaymentSystem(customerCardNumber, progressDialog);
            calculationMortgagePayments(progressDialog);
            progressDialog.showMortgagePayment();
        } else {
            progressDialog.showErrorsLog(errorResult);
            initMainApplication();
        }
    }

    private static void showPaymentSystem(String customerCardNumber, Dialog progressDialog) {

        BankingCardType[] bankingCardTypes = BankingCardType.values();
        CardTypeValidator cardTypeValidator = new CardTypeValidatorImpl(Integer.parseInt(String.valueOf(customerCardNumber.toCharArray()[0])));
        progressDialog.setCardTypeValidator(cardTypeValidator);
        cardTypeValidator.setPossibleCards(bankingCardTypes);
        progressDialog.showCardType();

    }

    private static void calculationMortgagePayments(Dialog progressDialog) {

        MortgagePayment mortgagePayment = new MortgagePaymentImpl();
        progressDialog.setMortgagePayment(mortgagePayment);
        mortgagePayment.setDetailsForCalculation(paymentSystem(progressDialog));
        mortgagePayment.monthlyPaymentCalculation();

    }

    private static double[] paymentSystem(Dialog progressDialog) {
        return progressDialog.customerPaymentMenu();
    }
}
