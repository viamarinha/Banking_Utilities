package dev.andrylat.bankingutilities.interfaces;

import dev.andrylat.bankingutilities.Enumerations.BankingCardType;

public interface CardTypeValidator {

    void setPossibleCards(BankingCardType[] bankingCardTypes);

    String customerCardType();
}
