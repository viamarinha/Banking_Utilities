package dev.andrylat.bankingutilities.Enumerations;


public enum BankingCardType  {
    MASTERCARD2017(2),
    AMERICANEXPRESS(3),
    VISA(4),
    MASTERCARD(5),
    DISCOVER(6);
    private int typeNumber;

    BankingCardType(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public int getCardType() {
        return typeNumber;
    }
}
