package dev.andrylat.bankingutilities.dialogs.impl;

import dev.andrylat.bankingutilities.card.validators.CardValidatorImpl;
import dev.andrylat.bankingutilities.dialogs.Dialog;
import dev.andrylat.bankingutilities.mortgagecalculator.MortgagePaymentImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InitialDialog implements Dialog {

    private Map<String, Runnable> commands;

    @Override
    public void start() {
        getDataFromCustomer();
    }

    private void getDataFromCustomer() {

        System.out.println("Make your choice please :" +
                " \n For credit card validation press 1 " +
                "\n For mortgage calculator press 2 " +
                "\n For exit press exit");

        Scanner scanner = new Scanner(System.in);
        String customerChoice = scanner.nextLine();

        boolean isFinished = false;
        while (!isFinished) {

            if ("exit".equalsIgnoreCase(customerChoice))
                break;
            setCustomerSystems();
            Runnable operation = commands.get(customerChoice);
            if (operation == null) {
                System.err.println("You have entered wrong choice");
                getDataFromCustomer();
            } else {
                operation.run();
                isFinished = true;
            }
        }
    }

    private void setCustomerSystems() {

        commands = new HashMap<>();
        commands.put("1", () -> cardValidation());
        commands.put("2", () -> mortgageCalculator());
    }

    private void cardValidation() {

        Dialog bankingDialog = new BankingDialog(new CardValidatorImpl());
        bankingDialog.start();
    }

    private void mortgageCalculator() {

        Dialog mortgageDialog = new MortgageDialog(new MortgagePaymentImpl());
        mortgageDialog.start();
    }
}
