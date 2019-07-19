import java.util.Arrays;
import java.util.List;

public class Demo {


    public static void main(String[] args) {

        Customer customer1 = new Customer("Ivanov", 52,new BankAccount("DE12345678123456" ));
        Customer customer2 = new Customer("Stepanov", 3, new BankAccount("IT1234567"));
        Customer customer3 = new Customer("Petrov", 23, new BankAccount("IT12345678123456"));
        Customer customer4 = new Customer("Sidorov", 17, new BankAccount("DE123456"));
        Customer customer5 = new Customer("Nikolaev", 14, new BankAccount("DE78945678123789"));
        List<Customer> listOfCustormers = Arrays.asList(customer1, customer2, customer3, customer4, customer5);

        validateCustomers(listOfCustormers);
    }

    public static void validateCustomers(List<Customer> list) {
        for (Customer c : list) {
            try {
                validateAge(c);
            } catch (InvalidAgeException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                validateIbanLength(c);
            } catch (InvalidIbanLengthException ex) {
                System.out.println(ex.getMessage());
            }

            try {
                validateIbanLetters(c);
            } catch (InvalidIbanLettersException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    protected  static void validateAge(Customer a) throws InvalidAgeException {
        if (a.getAge() < 17)
            throw new InvalidAgeException(a.getName() + " is younger than 17 and therefore " +
                    "can't open bank account");
    }


    protected  static void validateIbanLength(Customer a) throws InvalidIbanLengthException {
        if (a.getAccount().getIBAN().length() != 16)
            throw new InvalidIbanLengthException("The IBAN of " + a.getName() +
                    " has the wrong length");
    }


    protected static void validateIbanLetters(Customer a) throws InvalidIbanLettersException {
        if (!a.getAccount().getIBAN().startsWith("DE"))
            throw new InvalidIbanLettersException("The IBAN of " + a.getName() +
                    " is not of a German bank");
    }


}

