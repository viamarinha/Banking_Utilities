package dev.adrylat.bankingfunctionality.mortgagecalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortgagePaymentImplTest {

    private MortgagePaymentImpl mortgagePaymentImpl;
    private  final int YEAR = 1;
    private  final int MONTH = 2;
    private  final int WEEK = 3;
    private final int INCORRECT_PERIOD = 10;

    @BeforeEach
    void setUp() {

        mortgagePaymentImpl = new MortgagePaymentImpl();
    }

    @Test
    void weeklyPaymentCalculation_ShouldReturnWeeklyPayment_WhenWeeklyPaymentChosen() {
        CustomerData customerData = new CustomerData(1000, 20, 1, WEEK);
        mortgagePaymentImpl.setMortgageDetails(customerData);
        mortgagePaymentImpl.paymentCalculation();
        double expected = 21.25;
        double actual = mortgagePaymentImpl.getPayment();
        assertEquals(expected, actual);
    }

    @Test
    void monthlyPaymentCalculation_ShouldReturnMonthlyPayment_WhenMonthlyPaymentChosen() {
        CustomerData customerData = new CustomerData(1000, 20, 1, MONTH);
        mortgagePaymentImpl.setMortgageDetails(customerData);
        mortgagePaymentImpl.paymentCalculation();
        double expected = 92.63;
        double actual = mortgagePaymentImpl.getPayment();
        assertEquals(expected, actual);
    }

    @Test
    void yearlyPaymentCalculation_ShouldReturnYearlyPayment_WhenYearlyPaymentChosen() {
        CustomerData customerData = new CustomerData(1000, 20, 1, YEAR);
        mortgagePaymentImpl.setMortgageDetails(customerData);
        mortgagePaymentImpl.paymentCalculation();
        double expected = 1200.0;
        double actual = mortgagePaymentImpl.getPayment();
        assertEquals(expected, actual);
    }

    @Test
    void paymentCalculation_ShouldTrowException_WhenIncorrectInput() {
        CustomerData customerData = new CustomerData(1000, 20, 1, INCORRECT_PERIOD);
        mortgagePaymentImpl.setMortgageDetails(customerData);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> mortgagePaymentImpl.paymentCalculation());
        String expected = "Your data have an incorrect format";
        String actual = thrown.getMessage();
        assertEquals(expected, actual);
    }
}