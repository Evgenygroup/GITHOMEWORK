import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HomeworkIO {


    public static void main(String[] args) {
        System.out.println("------task1-----");
        System.out.println(SumInt(new File("task1.txt")));

        System.out.println("------task2-----");
        String[] arr = {"aaa", "bbbb", "a", "bb"};
        sortedLengthOf(arr);

        System.out.println("------task3-----");
        sortedByAge(new File("task3.csv"));


        System.out.println("------task4-----");
        Customers customer1 = new Customers("Ivan", "Ivanov", 35);
        Customers customer2 = new Customers("Petr", "Petrov", 45);
        Customers customer3 = new Customers("Semen", "Semenov", 25);
        List cust = Arrays.asList(customer1, customer2, customer3);

        outputCustomersToFile(cust, new File("task4.csv"));


    }

    //1.There is a text file of integers return sum of them.

    public static int SumInt(File file) {
        try (BufferedReader bf = new BufferedReader(new FileReader(file));) {
            int sum = bf.lines()
                    .map(s -> Integer.parseInt(s))
                    .reduce(0, (s1, s2) -> s1 + s2);
            return sum;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;

    }

    //2.sort strings in array by length
    public static void sortedLengthOf(String[] array) {
        List<String> strings = Arrays.asList(array);
        List<String> sorted = strings.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        String[] sortedArray = sorted.toArray(new String[sorted.size()]);
        Arrays.stream(sortedArray).forEach(System.out::println);
    }

    // 3. print out from text file  a list sorted by age of those older than 17

    public static void sortedByAge(File file) {
        try (BufferedReader bf = new BufferedReader(new FileReader(file));) {

            bf.lines()
                    .filter(s -> ifOlder17(s) > 17)
                    .map(s -> createPerson(s))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int ifOlder17(String string) {
        String[] data = string.split(",");
        return Integer.parseInt(data[1]);
    }

    public static PersonForTask3 createPerson(String string) {
        String[] data = string.split(",");
        return (new PersonForTask3(data[0], Integer.parseInt(data[1])));

    }

    // 4.  create a  .csv file of customers

    public static void outputCustomersToFile(List<Customers> list, File file) {
        try (PrintWriter pr = new PrintWriter(file);) {

            list.stream().forEach(c -> pr.println(createString(c)));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String createString(Customers customer) {
        return customer.firstname + "," + customer.lastname + "," + customer.age;
    }
}

class Customers {
    String firstname;
    String lastname;
    int age;

    public Customers(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;


    }
}




