import exceptions.BankAccount;
import exceptions.Customer;
import exceptions.Validator;
import exceptions.printing.Printer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoTests {

    private Validator v;
    private Printer printer;
    BankAccount account1;
    BankAccount account2;
    BankAccount account3;
    BankAccount account4;
    BankAccount account5;

    Customer customer1;
    Customer customer2;
    Customer customer3;
    Customer customer4;
    Customer customer5;

    List<Customer> listOfCustomers;


    @Before
    public void init() {
        printer = mock(Printer.class);
        v = new Validator(printer);
    }

    @Test
    public void allGood() {
        account1 = new BankAccount("DE12345678909876");
        account2 = new BankAccount("DE12345678909876");
        account3 = new BankAccount("DE12345678909876");

        customer1 = new Customer("Customer1", 25, account1);
        customer2 = new Customer("Customer2", 18, account2);
        customer3 = new Customer("Customer3", 70, account3);

        listOfCustomers = Arrays.asList(customer1, customer2, customer3);

        v.validateAllCustomers(listOfCustomers);
        verify(printer, times(0)).print(anyString());
    }

    @Test
    public void ageWrong() {
        account1 = new BankAccount("DE12345678909876");
        account2 = new BankAccount("DE12345678909876");
        account3 = new BankAccount("DE12345678909876");

        customer1 = new Customer("Customer1", 25, account1);
        customer2 = new Customer("Customer2", 14, account2);
        customer3 = new Customer("Customer3", 70, account3);

        listOfCustomers = Arrays.asList(customer1, customer2, customer3);

        v.validateAllCustomers(listOfCustomers);
        verify(printer, times(1)).print("Customer2 age is less than 17");
    }

    @Test
    public void countryWrong() {
        account1 = new BankAccount("DE12345678909876");
        account2 = new BankAccount("IT12345678909876");
        account3 = new BankAccount("DE12345678909876");

        customer1 = new Customer("Customer1", 25, account1);
        customer2 = new Customer("Customer2", 18, account2);
        customer3 = new Customer("Customer3", 70, account3);

        listOfCustomers = Arrays.asList(customer1, customer2, customer3);

        v.validateAllCustomers(listOfCustomers);
        verify(printer, times(1)).print("Customer2 account is foreign.");
    }

    @Test
    public void ibanLengthWrong() {
        account1 = new BankAccount("DE12345678909876");
        account2 = new BankAccount("DE12345678909876");
        account3 = new BankAccount("DE123456789");

        customer1 = new Customer("Customer1", 25, account1);
        customer2 = new Customer("Customer2", 18, account2);
        customer3 = new Customer("Customer3", 70, account3);

        listOfCustomers = Arrays.asList(customer1, customer2, customer3);

        v.validateAllCustomers(listOfCustomers);
        verify(printer, times(1)).print("Customer3 IBAN has wrong length");
    }

    @Test()
    public void aLotIsWrong() {
        account1 = new BankAccount("DE12345678909876");
        account2 = new BankAccount("DE12345678909876");
        account3 = new BankAccount("IT12345678909876");
        account4 = new BankAccount("DE1234567");
        account5 = new BankAccount("IT123");

        customer1 = new Customer("Customer1", 25, account1);
        customer2 = new Customer("Customer2", 14, account2);
        customer3 = new Customer("Customer3", 70, account3);
        customer4 = new Customer("Customer4", 17, account4);
        customer5 = new Customer("Customer5", 2, account5);

        listOfCustomers = Arrays.asList(customer1, customer2, customer3, customer4, customer5);
        v.validateAllCustomers(listOfCustomers);
        verify(printer, times(6)).print(anyString());


    }
}




