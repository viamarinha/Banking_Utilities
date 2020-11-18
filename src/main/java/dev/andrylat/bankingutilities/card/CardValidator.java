package dev.andrylat.bankingutilities.card;

import java.util.List;

public interface CardValidator {

    List<String> validate(String customerInput);

}
