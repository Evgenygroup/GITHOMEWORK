package stream_homework.person_address_account_iban;

import java.util.List;

public class Person1 {
    String name;
    List<BankAccount1> bankAccounts;

    public Person1(String name, List<BankAccount1> bankAccounts) {
        this.name = name;
        this.bankAccounts = bankAccounts;
    }

    public String getName() {
        return name;
    }

    public List<BankAccount1> getBankAccounts() {
        return bankAccounts;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}
