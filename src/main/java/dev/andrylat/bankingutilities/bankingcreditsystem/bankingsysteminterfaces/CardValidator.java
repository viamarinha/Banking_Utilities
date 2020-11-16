package dev.andrylat.bankingutilities.bankingcreditsystem.bankingsysteminterfaces;

import java.util.List;

public interface CardValidator {
     List<String> validate(String customerInput);
}
