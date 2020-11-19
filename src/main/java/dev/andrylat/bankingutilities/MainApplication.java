package dev.andrylat.bankingutilities;

import dev.andrylat.bankingutilities.dialogs.Dialog;
import dev.andrylat.bankingutilities.dialogs.impl.DialogImpl;

public class MainApplication {

    public static void main(String[] args) {

        initMainApplication();

    }

    private static void initMainApplication() {


        Dialog dialog = new DialogImpl();
        dialog.start();

    }
}
