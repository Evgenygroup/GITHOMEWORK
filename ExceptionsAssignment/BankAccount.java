package exceptions;

public class BankAccount {
    String iban;

    public BankAccount(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                '}';
    }
}
