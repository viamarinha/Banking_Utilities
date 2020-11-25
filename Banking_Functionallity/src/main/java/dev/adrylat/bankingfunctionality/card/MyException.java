package dev.adrylat.bankingfunctionality.card;

import java.util.List;

public class MyException extends Exception {

    private  List<String> errorList;

    public MyException(List<String> errorList) {
        this.errorList = errorList;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public  void showErrorsLog() {
        errorList.forEach(System.err::println);
    }
}
