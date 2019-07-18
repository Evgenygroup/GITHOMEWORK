import org.junit.Test;

public class DemoTests {

    @Test
    public void testValidateAgeValid() throws Exception {
        Customer customer = new Customer("Ivanov", 52
                ,new BankAccount("DE12345678123456" )); //true
        Demo.validateAge(customer);
    }

    @Test(expected = InvalidAgeException.class)
    public void testValidateAgeWrong() throws InvalidAgeException {

        Customer customer = new Customer("Ivanov", 16
                , new BankAccount("DE12345678123456"));//wrong
        Demo.validateAge(customer);

    }

    @Test
    public void testValidateIbanLengthValid() throws Exception {
        Customer customer = new Customer("Ivanov", 52
                , new BankAccount("DE12345678123456"));//true
        Demo.validateIbanLength(customer);

    }

    @Test(expected = InvalidIbanLengthException.class)
    public void testValidateIbanLengthWrong() throws InvalidIbanLengthException {
        Customer customer = new Customer("Ivanov", 52
                , new BankAccount("DE12345")); //wrong
        Demo.validateIbanLength(customer);

    }

    @Test
    public void testValidateIbanLettersValid() throws Exception {

        Customer customer = new Customer("Ivanov", 52
                , new BankAccount("DE12345678123456"));//true
        Demo.validateIbanLetters(customer);

    }

    @Test(expected = InvalidIbanLettersException.class)
    public void testValidateIbanLettersWrong() throws InvalidIbanLettersException {
        Customer customer = new Customer("Ivanov", 52
                , new BankAccount("IT12345678123456")); //wrong
        Demo.validateIbanLetters(customer);
    }


}
