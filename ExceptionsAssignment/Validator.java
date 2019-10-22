package exceptions;

import exceptions.exceptions.ExceptionAge;
import exceptions.exceptions.ExceptionCountry;
import exceptions.exceptions.ExceptionIbanLength;
import exceptions.printing.PrintToscreen;
import exceptions.printing.Printer;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private Printer printer;

    public Validator(Printer printer) {
        this.printer = printer;
    }

    public void validateAllCustomers(List<Customer> list) {
        for (Customer c : list) {
            validateCustomer(c);
        }
    }


    private void validateCustomer(Customer customer) {

        try {
            checkAge(customer);
        } catch (ExceptionAge e) {
            printer.print(customer + " age is less than 17");
        }
        try {
            checkCountry(customer);
        } catch (ExceptionCountry e1) {
            printer.print(customer + " account is foreign.");
        }
        try {
            checkIbanLength(customer);
        } catch (ExceptionIbanLength e2) {
            printer.print(customer + " IBAN has wrong length");
        }

    }

    private void checkAge(Customer customer) throws ExceptionAge {
        if (customer.age < 17) throw new ExceptionAge(customer + " age is less than 17");
    }

    private void checkCountry(Customer customer) throws ExceptionCountry {
        if (!customer.account.iban.substring(0, 2).equals("DE"))
            throw new ExceptionCountry(customer + " account is foreign.");
    }

    private void checkIbanLength(Customer customer) throws ExceptionIbanLength {
        if (customer.account.iban.length() != 16) throw new ExceptionIbanLength(customer + " IBAN has wrong length");

    }


}
