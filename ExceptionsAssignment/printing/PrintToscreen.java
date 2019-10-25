package exceptions.printing;

public class PrintToscreen implements Printer {
    public void print(String message) {
        System.out.println(message);
    }
}
