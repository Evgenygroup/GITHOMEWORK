import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeworkIO2 {

    private static  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {

        NamesSortedByCost(new File("task1-2.csv"), new File("task1-2out.csv"));
        listNamesSortedByDates(new File("task2-2.csv"), new File("task2-2out.csv"));
    }
//1.JavaIOAssignment2, Task 2. (Sergey,Lukichev,Notebook Lenovo,500 -> Sergey Lukichev, 525)
    public static void NamesSortedByCost(File file, File file1) {
        try (BufferedReader br = new BufferedReader(new FileReader(file));
             PrintWriter pr = new PrintWriter(file1)) {
            Map<String, Integer> listNamesCosts = br.lines()
                    .map(HomeworkIO2::createPerson)
                    .collect(Collectors.groupingBy(PersonCosts::getName,
                            Collectors.summingInt(PersonCosts::getPrice)));

            listNamesCosts
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(s -> s.getValue()))
                    .forEach(entry -> pr.println(entry.getKey() + ',' + entry.getValue()));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static PersonCosts createPerson(String string) {
        String[] data = string.split(",");
        return new PersonCosts(data[0] + " " + data[1], Integer.parseInt(data[3]));
    }


    //2.JavaIOAssignment2, Task 3 return file with names sorted by DoB

    public static void listNamesSortedByDates(File file, File file1) {

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             PrintWriter pr = new PrintWriter(file1)) {
            br.lines()
                    .map(HomeworkIO2::createPersonForTask2)
                    .sorted(Comparator.comparing(PersonForTask2::getDateOfBirth))
                    .forEach(p -> pr.println(createStringForTask2(p)));


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static PersonForTask2 createPersonForTask2(String str) {
        String[] data = str.split(",");
        return new PersonForTask2(data[0], LocalDate.parse(data[1], formatter));
    }

    public static String createStringForTask2(PersonForTask2 person) {
        return person.getName() + "," + person.getDateOfBirth().format(formatter);
    }
}

class PersonCosts {

    private String name;
    private int price;

    public PersonCosts(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}


