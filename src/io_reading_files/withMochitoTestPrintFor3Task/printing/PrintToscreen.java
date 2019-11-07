package printing;

public class PrintToscreen implements Printer {
    public void print(Person person) {
        System.out.println(person);
    }
}
