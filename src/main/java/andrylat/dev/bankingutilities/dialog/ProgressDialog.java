package andrylat.dev.bankingutilities.dialog;

import andrylat.dev.bankingutilities.interfaces.Dialog;
import andrylat.dev.bankingutilities.interfaces.ValidatorInt;

import java.util.Map;
import java.util.Scanner;

public class ProgressDialog implements Dialog {

    private ValidatorInt validatorInt;


    public void setCustomerInteraction(ValidatorInt validatorInt)  {
        this.validatorInt = validatorInt;
    }

    public  String getCustomerData() {
        System.out.println("Enter a card number with 16 digits");
        System.out.println("Ex : xxxx-xxxx-xxxx-xxxx or \n xxxx xxxx xxxx xxxx");
        Scanner scanner = new Scanner(System.in);
        String customerCardNumber = scanner.nextLine();

        return customerCardNumber;
    }

    public   <K, V> void showErrorsLog(Map<K, V> errorResult) {
        for (Map.Entry<K, V> entry : errorResult.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


    public Map<String, String> interactionWithCustomer(String customerInput) {
        return validatorInt.interactionWithCustomer(customerInput);
    }
}
