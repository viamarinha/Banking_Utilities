package dev.andrylat.bankingutilities.validators;


import dev.andrylat.bankingutilities.Enumerations.BankingCardType;
import dev.andrylat.bankingutilities.interfaces.CardTypeValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Pass enum values to our test method")
class CardTypeValidatorImplTest {

    @DisplayName("Pass enum values to our test method")
    @ParameterizedTest(name = "{index} - Run test with args = {0}")
    @EnumSource(BankingCardType.class)
    void shouldPassNonNullEnumValuesAsMethodParameter(BankingCardType bankingCardType) {
        assertNotNull(bankingCardType);
    }

    private static BankingCardType[] bankingCardTypes;
    private  CardTypeValidator cardTypeValidator;

    @BeforeAll
    static void setUp() {
        bankingCardTypes =  BankingCardType.values();
    }

    @Test
    void customerCardType_returnMASTERCARD2017_passedValue2() {
        int MASTERCARD2017 = 2;
         cardTypeValidator = new CardTypeValidatorImpl(MASTERCARD2017);
         cardTypeValidator.setPossibleCards(bankingCardTypes);
         assertEquals(cardTypeValidator.customerCardType(), "MASTERCARD2017" );
    }

    @Test
    void customerCardType_returnAMERICANEXPRESS_passedValue3() {
        int AMERICANEXPRESS = 3;
        cardTypeValidator = new CardTypeValidatorImpl(AMERICANEXPRESS);
        cardTypeValidator.setPossibleCards(bankingCardTypes);
        assertEquals(cardTypeValidator.customerCardType(), "AMERICANEXPRESS" );
    }
    @Test
    void customerCardType_returnVISA_passedValue4() {
        int VISA = 4;
        cardTypeValidator = new CardTypeValidatorImpl(VISA);
        cardTypeValidator.setPossibleCards(bankingCardTypes);
        assertEquals(cardTypeValidator.customerCardType(), "VISA" );
    }
    @Test
    void customerCardType_returnMASTERCARD_passedValue5() {
        int MASTERCARD = 5;
        cardTypeValidator = new CardTypeValidatorImpl(MASTERCARD);
        cardTypeValidator.setPossibleCards(bankingCardTypes);
        assertEquals(cardTypeValidator.customerCardType(), "MASTERCARD" );
    }
    @Test
    void customerCardType_returnDISCOVER_passedValue6() {
        int DISCOVER = 6;
        cardTypeValidator = new CardTypeValidatorImpl(DISCOVER);
        cardTypeValidator.setPossibleCards(bankingCardTypes);
        assertEquals(cardTypeValidator.customerCardType(), "DISCOVER" );
    }

}
