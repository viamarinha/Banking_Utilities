package dev.adrylat.bankingfunctionality.card.exceptions;

import java.util.List;

public class CardValidatorException extends Exception {

    private  List<String> errorList;

    public CardValidatorException(List<String> errorList) {
        this.errorList = errorList;
    }

    public List<String> getErrorList() {
        return errorList;
    }

}
