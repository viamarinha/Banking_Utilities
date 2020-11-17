package dev.andrylat.bankingutilities;

import dev.andrylat.bankingutilities.dialog.*;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePayment;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePaymentImpl;
import dev.andrylat.bankingutilities.cardvalidator.validators.InitialSystemValidator;
import dev.andrylat.bankingutilities.cardvalidator.validators.PaymentValidator;
import dev.andrylat.bankingutilities.cardvalidator.validators.CardValidator;
import dev.andrylat.bankingutilities.cardvalidator.validators.InitialSystemValidatorImpl;
import dev.andrylat.bankingutilities.cardvalidator.validators.PaymentValidatorImpl;
import dev.andrylat.bankingutilities.cardvalidator.validators.CardValidatorImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApplication {

    public static void main(String[] args) {

        initMainApplication();

    }

    private static void initMainApplication() {


        Dialog initDialog = new InitialDialogImpl();

        InitialSystemValidator initialSystemValidator = new InitialSystemValidatorImpl();
        ((InitialDialogImpl) initDialog).setInitialSystemValidator(initialSystemValidator);

//        boolean validCustomerInput = false;
//        while (!validCustomerInput) {
//
//            validCustomerInput = initialSystemValidator.validateCustomerChoice(customerSystemChoice);
    }


    private static void bankingSystemValidation() {

        BankingSystemDialog bankingSystemDialog = new BankingSystemDialogImpl();
        CardValidator cardValidator = new CardValidatorImpl();
        bankingSystemDialog.setBankingCardValidator(cardValidator);
        String customerCardNumber = bankingSystemDialog.getCustomerData();

        List<String> errorResult = bankingSystemDialog.validateCustomerInput(customerCardNumber);
        if (errorResult == null) {
            showPaymentSystem(customerCardNumber, bankingSystemDialog);
        } else {
            bankingSystemDialog.showErrorsLog(errorResult);
            bankingSystemValidation();
        }
    }

    private static void showPaymentSystem(String customerCardNumber, BankingSystemDialog bankingSystemDialog) {

        int paymentCompanyIdentifier = Integer.parseInt(String.valueOf(customerCardNumber.toCharArray()[0]));
        PaymentValidator paymentValidator = new PaymentValidatorImpl(paymentCompanyIdentifier);
        bankingSystemDialog.setCardTypeValidator(paymentValidator);
        bankingSystemDialog.showCardType();

    }

    private static void mortgageCalculation() {

        MortgagePayment mortgagePayment = new MortgagePaymentImpl();
        MortgageDialog mortgageDialog = new MortgageDialogImpl();
        mortgageDialog.setMortgagePayments(mortgagePayment);
        mortgagePayment.setDetailsForCalculation(mortgageDialog.customerPaymentMenu());
        mortgagePayment.paymentCalculation();
        mortgageDialog.showResult();

    }
}
