package dev.andrylat.bankingutilities.card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentValidatorImplTest {

    @Test
    void customerCardType_ShouldReturnMasterCard2017_WhenSystemId2() {

        int systemId = 2;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "MasterCard2017";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_ShouldReturnAmericanExpress_WhenSystemId3(){

        int systemId = 3;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "AmericanExpress";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_ShouldReturnVisa_WhenSystemId4(){

        int systemId = 4;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "Visa";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_ShouldReturnMasterCard_WhenSystemId5(){

        int systemId = 5;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "MasterCard";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_ShouldReturnMasterCard_WhenSystemId6(){

        int systemId = 6;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "Discover";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_ShouldReturnNull_WhenSystemIdDoestExist() {

        int systemId = 9;
        PaymentSystem actual = PaymentSystem.getCardCompanyByIdentifier(systemId);
        Object expected = null;
        assertEquals(expected, actual);
    }
}