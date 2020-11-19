package dev.andrylat.bankingutilities.card.validators;

import java.util.List;

public interface CardValidator {

    List<String> validate(String customerInput);

    String customerCardType();

     void setPaymentCompanyIdentifier(int paymentCompanyIdentifier);

}
