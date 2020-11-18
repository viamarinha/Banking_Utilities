package dev.andrylat.bankingutilities.dialogs;

import dev.andrylat.bankingutilities.card.CardValidator;
import dev.andrylat.bankingutilities.card.CardValidatorImpl;
import dev.andrylat.bankingutilities.card.PaymentValidator;
import dev.andrylat.bankingutilities.card.PaymentValidatorImpl;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePayment;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePaymentImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DialogImpl implements Dialog {
    @Override
    public void start() {
        getDataFromCustomer();
    }

    private void getDataFromCustomer() {

        System.out.println("Make your choice please :" +
                " \n For credit card validation press 1 " +
                "\n For mortgage calculator press 2 ");

        Scanner scanner = new Scanner(System.in);
        String customerChoice = scanner.nextLine();

        while (true) {
            if (customerChoice.equals("1") || customerChoice.equals("2")) {
                break;
            }
            System.out.println("You have entered wrong choice");
            getDataFromCustomer();
        }
        getCustomerSystem(customerChoice);
    }

    private void getCustomerSystem(String customerChoice) {
        Map<String, Runnable> commands = new HashMap<>();
        commands.put("1", () -> cardValidation());
        commands.put("2", () -> mortgageCalculator());

        commands.get(customerChoice).run();
    }

    private void mortgageCalculator() {

        MortgagePayment mortgagePayment = new MortgagePaymentImpl();
        MortgageDialog mortgageDialog = new MortgageDialogImpl();
        mortgageDialog.setMortgagePayments(mortgagePayment);
        mortgagePayment.setDetailsForCalculation(mortgageDialog.customerPaymentMenu());
        mortgagePayment.paymentCalculation();
        mortgageDialog.showResult();
    }

    private void cardValidation() {
        BankingSystemDialog bankingSystemDialog = new BankingSystemDialogImpl();
        CardValidator cardValidator = new CardValidatorImpl();
        bankingSystemDialog.setBankingCardValidator(cardValidator);
        String customerCardNumber = bankingSystemDialog.getCustomerData();

        List<String> errorResult = bankingSystemDialog.validateCustomerInput(customerCardNumber);
        if (errorResult.isEmpty()) {
            showPaymentSystem(customerCardNumber, bankingSystemDialog);
        } else {
            bankingSystemDialog.showErrorsLog(errorResult);
            cardValidation();
        }
    }

    private static void showPaymentSystem(String customerCardNumber, BankingSystemDialog bankingSystemDialog) {

        int paymentCompanyIdentifier = Integer.parseInt(String.valueOf(customerCardNumber.toCharArray()[0]));
        PaymentValidator paymentValidator = new PaymentValidatorImpl(paymentCompanyIdentifier);
        bankingSystemDialog.setCardTypeValidator(paymentValidator);
        bankingSystemDialog.showCardType();
    }
}