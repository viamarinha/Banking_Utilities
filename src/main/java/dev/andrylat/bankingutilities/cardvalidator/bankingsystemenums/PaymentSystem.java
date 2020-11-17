package dev.andrylat.bankingutilities.cardvalidator.bankingsystemenums;

public enum PaymentSystem {

    MASTERCARD2017(2, "MasterCard2017"),
    AMERICANEXPRESS(3, "AmericanExpress"),
    VISA(4, "Visa"),
    MASTERCARD(5, "MasterCard"),
    DISCOVER(6, "Discover");

    private final int paymentSystemIdentifier;
    private final String paymentType;

    PaymentSystem(int paymentSystemIdentifier, String paymentType) {
        this.paymentSystemIdentifier = paymentSystemIdentifier;
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public int getPaymentSystemIdentifier() {
        return paymentSystemIdentifier;
    }

    public static PaymentSystem getCardCompanyByIdentifier(int identifier) {

        for (PaymentSystem paymentSystem : values()) {
            if (paymentSystem.getPaymentSystemIdentifier() == identifier) {
                return paymentSystem;
            }
        }
        return null;
    }
}
