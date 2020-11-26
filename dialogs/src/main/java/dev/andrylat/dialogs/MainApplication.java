package dev.andrylat.dialogs;

import dev.andrylat.dialogs.impl.InitialDialog;

public class MainApplication {

    public static void main(String[] args) {

        Dialog dialog = new InitialDialog();
        dialog.start();
    }

}
