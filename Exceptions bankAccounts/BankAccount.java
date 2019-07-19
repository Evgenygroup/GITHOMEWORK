public class BankAccount {

    private String IBAN;

    public BankAccount(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;

    }

    @Override
    public String toString() {
        return "IBAN='" + IBAN;
    }
}
