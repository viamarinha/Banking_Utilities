package dev.andrylat.bankingutilities.cardvalidator.validators;

import dev.andrylat.bankingutilities.cardvalidator.bankingsystemenums.PaymentSystem;

public class PaymentValidatorImpl implements PaymentValidator {


    private int paymentCompanyIdentifier;

    public PaymentValidatorImpl(int paymentCompanyIdentifier) {
        this.paymentCompanyIdentifier = paymentCompanyIdentifier;
    }


    @Override
    public String customerCardType() {
      PaymentSystem paymentSystem =  PaymentSystem.getCardCompanyByIdentifier(paymentCompanyIdentifier);
      if(paymentSystem != null){
          return paymentSystem.getPaymentType();
      }
      else {
          return null;
      }
    }
}
