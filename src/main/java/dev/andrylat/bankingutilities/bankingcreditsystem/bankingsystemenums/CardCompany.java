package dev.andrylat.bankingutilities.bankingcreditsystem.bankingsystemenums;


import java.util.logging.Logger;

public enum CardCompany {

    MASTERCARD2017(2, "MasterCard2017"),
    AMERICANEXPRESS(3, "AmericanExpress"),
    VISA(4, "Visa"),
    MASTERCARD(5, "MasterCard"),
    DISCOVER(6, "Discover");

    private final int paymentSystemIdentifier;
    private final String paymentType;

    CardCompany(int paymentSystemIdentifier, String paymentType) {
        this.paymentSystemIdentifier = paymentSystemIdentifier;
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public int getPaymentSystemIdentifier() {
        return paymentSystemIdentifier;
    }

    public static CardCompany getCardCompanyByIdentifier(int identifier) {
        try {
            for (CardCompany cardCompany : values()) {
                if (cardCompany.getPaymentSystemIdentifier() == identifier) {
                    return cardCompany;
                }
            }
        } catch (NullPointerException ex) {
          Logger.getLogger(ex.getMessage());
        }
        return null;
    }
}
