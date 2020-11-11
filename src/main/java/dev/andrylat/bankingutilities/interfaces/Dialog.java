package dev.andrylat.bankingutilities.interfaces;

import java.util.List;
import java.util.Map;

public interface Dialog {

    String getCustomerData();

    <K> void showErrorsLog(List<K> errorResult);

    List<String> interactionWithCustomer(String customerInput);

    void setCustomerInteraction(CardValidator bankingCardValidator);
}
