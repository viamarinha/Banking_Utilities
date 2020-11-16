package dev.andrylat.bankingutilities.initialsystem.systemchoicedialog;

import java.util.Scanner;

public class InitialDialogImpl implements InitialDialog {

    @Override
    public String startDialog() {

        System.out.println("Make your choice please :" +
                " \n For credit card validation press 1 " +
                "\n For mortgage calculator press 2 ");
        Scanner scanner = new Scanner(System.in);
        String customerChoice = scanner.nextLine();

        return customerChoice;
    }
}
