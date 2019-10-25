package exceptions;

public class Customer {
    String name;
    int age;
    BankAccount account;

    public Customer(String name, int age, BankAccount account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    @Override
    public String toString() {
        return name;
    }
}
