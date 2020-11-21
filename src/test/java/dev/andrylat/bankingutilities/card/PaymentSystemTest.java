package dev.andrylat.bankingutilities.card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentValidatorImplTest {

    @Test
    void customerCardType_shouldReturnMasterCard2017_whenSystemId2() {

        int systemId = 2;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "MasterCard2017";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnAmericanExpress_whenSystemId3(){

        int systemId = 3;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "AmericanExpress";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnVisa_whenSystemId4(){

        int systemId = 4;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "Visa";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnMasterCard_whenSystemId5(){

        int systemId = 5;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "MasterCard";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnMasterCard_whenSystemId6(){

        int systemId = 6;
        PaymentSystem paymentSystem = PaymentSystem.getCardCompanyByIdentifier(systemId);
        String actual = "Discover";
        String expected = paymentSystem.getPaymentType();
        assertEquals(expected, actual);
    }



}