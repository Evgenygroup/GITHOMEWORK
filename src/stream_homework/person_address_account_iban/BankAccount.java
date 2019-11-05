package stream_homework.person_address_account_iban;

public class BankAccount {

    String Iban;
    Person owner;

    public String getIban() {
        return Iban;
    }

    public Person getOwner() {
        return owner;
    }

    public BankAccount(String iban, Person owner) {
        Iban = iban;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "Iban='" + Iban + '\'' +
                ", owner=" + owner +
                '}';
    }
}
