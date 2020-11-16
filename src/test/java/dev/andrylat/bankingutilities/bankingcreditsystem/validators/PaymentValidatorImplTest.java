package dev.andrylat.bankingutilities.bankingcreditsystem.validators;

import dev.andrylat.bankingutilities.bankingcreditsystem.bankingsystemenums.CardCompany;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PaymentValidatorImplTest {

    @Test
    void customerCardType_shouldReturnMasterCard2017_whenSystemId2() {

        int systemId = 2;
        CardCompany cardCompany = CardCompany.getCardCompanyByIdentifier(systemId);
        String actual = "MasterCard2017";
        String expected = cardCompany.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnAmericanExpress_whenSystemId3(){

        int systemId = 3;
        CardCompany cardCompany = CardCompany.getCardCompanyByIdentifier(systemId);
        String actual = "AmericanExpress";
        String expected = cardCompany.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnVisa_whenSystemId4(){

        int systemId = 4;
        CardCompany cardCompany = CardCompany.getCardCompanyByIdentifier(systemId);
        String actual = "Visa";
        String expected = cardCompany.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnMasterCard_whenSystemId5(){

        int systemId = 5;
        CardCompany cardCompany = CardCompany.getCardCompanyByIdentifier(systemId);
        String actual = "MasterCard";
        String expected = cardCompany.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnMasterCard_whenSystemId6(){

        int systemId = 6;
        CardCompany cardCompany = CardCompany.getCardCompanyByIdentifier(systemId);
        String actual = "Discover";
        String expected = cardCompany.getPaymentType();
        assertEquals(expected, actual);
    }

    @Test
    void customerCardType_shouldReturnNull_whenWrongSystemId(){

        int systemId = 8;
        CardCompany cardCompany = CardCompany.getCardCompanyByIdentifier(systemId);
        Class<NullPointerException> expected = NullPointerException.class ;
        Executable actual = () -> cardCompany.getPaymentType();
        assertThrows(expected, actual);

    }

}