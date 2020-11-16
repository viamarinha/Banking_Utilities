package dev.andrylat.bankingutilities;

import dev.andrylat.bankingutilities.mortgagecalculator.mortgagedialog.MortgageDialog;
import dev.andrylat.bankingutilities.mortgagecalculator.mortgagedialog.MortgageDialogImpl;
import dev.andrylat.bankingutilities.mortgagecalculator.mortgagepayment.MortgagePayment;
import dev.andrylat.bankingutilities.mortgagecalculator.mortgagepayment.MortgagePaymentImpl;
import dev.andrylat.bankingutilities.initialsystem.systemchoicedialog.InitialDialogImpl;
import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsystemsdialogs.BankingSystemDialogImpl;
import dev.andrylat.bankingutilities.initialsystem.systemchoicevalidators.InitialSystemValidator;
import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsysteminterfaces.PaymentValidator;
import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsystemsdialogs.BankingSystemDialog;
import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsysteminterfaces.CardValidator;
import dev.andrylat.bankingutilities.initialsystem.systemchoicedialog.InitialDialog;
import dev.andrylat.bankingutilities.initialsystem.systemchoicevalidators.InitialSystemValidatorImpl;
import dev.andrylat.bankingutilities.bankingcreditsystem.validators.PaymentValidatorImpl;
import dev.andrylat.bankingutilities.bankingcreditsystem.validators.CardValidatorImpl;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        initMainApplication();

    }

    private static void initMainApplication() {

        String customerSystemChoice = "";
        InitialDialog initDialog = new InitialDialogImpl();
        InitialSystemValidator initialSystemValidator = new InitialSystemValidatorImpl();
        boolean validCustomerInput = false;
        while (!validCustomerInput) {
            customerSystemChoice = initDialog.startDialog();
            validCustomerInput = initialSystemValidator.validateCustomerChoice(customerSystemChoice);
        }
        int system = Integer.parseInt(customerSystemChoice);
        switch (system) {
            case 1:
                bankingSystemValidation();
                break;
            case 2:
                mortgageCalculation();
                break;
            default:
                break;
        }

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
