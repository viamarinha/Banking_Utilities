package andrylat.dev.bankingutilities.interfaces;

import java.util.Map;

public interface Dialog {

    String getCustomerData();

    <K, V> void showErrorsLog(Map<K, V> errorResult);

    Map<String, String> interactionWithCustomer(String customerInput);

    void setCustomerInteraction(ValidatorInt bankingCardValidator);
}
