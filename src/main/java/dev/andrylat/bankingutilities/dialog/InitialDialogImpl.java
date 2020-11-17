package dev.andrylat.bankingutilities.dialog;

import dev.andrylat.bankingutilities.cardvalidator.validators.InitialSystemValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InitialDialogImpl implements InitialDialog {



    private InitialSystemValidator initialSystemValidator;
    Map<String, Dialog> systemChose;



    public void start() {

        System.out.println("Make your choice please :" +
                " \n For credit card validation press 1 " +
                "\n For mortgage calculator press 2 ");

        Scanner scanner = new Scanner(System.in);
        String customerChoice = scanner.nextLine();

        if(validateCustomerChoice(customerChoice)){

            setAvailableSystems();
            systemChose.get(customerChoice);

        }
    }

    private void setAvailableSystems() {

        systemChose = new HashMap<>();
        systemChose.put("1", new BankingSystemDialogImpl());
        systemChose.put("2", new MortgageDialogImpl());

    }

    private void mortgageCalculation() {

    }



    private boolean validateCustomerChoice(String customerChoice){

      return initialSystemValidator.validateCustomerChoice(customerChoice);
    }


    public void setInitialSystemValidator(InitialSystemValidator initialSystemValidator) {
        this.initialSystemValidator = initialSystemValidator;
    }

}
