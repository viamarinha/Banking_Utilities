package dev.andrylat.dialogs.impl;


import dev.adrylat.bankingfunctionality.card.validators.CardValidatorImpl;
import dev.andrylat.dialogs.Dialog;
import dev.adrylat.bankingfunctionality.mortgagecalculator.MortgagePaymentImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InitialDialog implements Dialog {

    private Map<String, Runnable> commands;

    public InitialDialog() {

        setPossibleChoices();
    }

    @Override
    public void start() {
        getDataFromCustomer();
    }

    private void getDataFromCustomer() {

        System.out.println("\n Make your choice please :" +
                " \n For credit card validation press 1 " +
                "\n For mortgage calculator press 2 " +
                "\n For exit press exit");

        Scanner scanner = new Scanner(System.in);
        String customerChoice = scanner.nextLine();

        boolean isFinished = false;
        while (!isFinished) {

            if ("exit".equalsIgnoreCase(customerChoice))
                isFinished = true;
            Runnable operation = commands.get(customerChoice);
            if (operation == null) {
                System.err.println("You have entered wrong choice");
                getDataFromCustomer();
            } else {
                operation.run();
                getDataFromCustomer();
            }
        }
    }

    private void setPossibleChoices() {

        commands = new HashMap<>();
        commands.put("1", () -> cardValidation());
        commands.put("2", () -> mortgageCalculator());
        commands.put("exit", () -> endProgram());
    }

    private void endProgram() {
        System.exit(0);
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
