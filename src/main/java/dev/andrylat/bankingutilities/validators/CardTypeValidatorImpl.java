package dev.andrylat.bankingutilities.validators;

import dev.andrylat.bankingutilities.Enumerations.BankingCardType;
import dev.andrylat.bankingutilities.interfaces.CardTypeValidator;

public class CardTypeValidatorImpl implements CardTypeValidator {

    private BankingCardType[] bankingCardTypes;
    private int firstCardDigit;

    public CardTypeValidatorImpl(int firstCardDigit) {
        this.firstCardDigit = firstCardDigit;
    }

    @Override
    public void setPossibleCards(BankingCardType[] bankingCardTypes) {
         this.bankingCardTypes = bankingCardTypes;
    }

    @Override
    public String customerCardType() {
        String cardType = "";
        for(BankingCardType enumType : bankingCardTypes){
            if(enumType.getCardType() == firstCardDigit)
                cardType = enumType.name();
        }
        return cardType;
    }
}
