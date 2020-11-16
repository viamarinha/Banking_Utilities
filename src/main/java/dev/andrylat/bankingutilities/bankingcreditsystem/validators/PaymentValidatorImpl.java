package dev.andrylat.bankingutilities.bankingcreditsystem.validators;

import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsystemenums.CardCompany;
import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsysteminterfaces.PaymentValidator;

public class PaymentValidatorImpl implements PaymentValidator {


    private int paymentCompanyIdentifier;

    public PaymentValidatorImpl(int paymentCompanyIdentifier) {
        this.paymentCompanyIdentifier = paymentCompanyIdentifier;
    }


    @Override
    public String customerCardType() {
      CardCompany cardCompany =  CardCompany.getCardCompanyByIdentifier(paymentCompanyIdentifier);
      if(cardCompany != null){
          return cardCompany.getPaymentType();
      }
      else {
          return null;
      }
    }
}
