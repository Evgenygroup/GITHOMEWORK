package stream_homework.person_address_account_iban;

public class BankAccount1 {
    public BankAccount1(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    String iban;

    @Override
    public String toString() {
        return "BankAccount1{" +
                "iban='" + iban + '\'' +
                '}';
    }
}
