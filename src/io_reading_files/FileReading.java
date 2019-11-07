package io_reading_files;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileReading {
    public static void main(String[] args) {
        FileReading fileReading = new FileReading();

        fileReading.sortedNamesbyAgeOlder17("task3.csv");

        Customer customer1 = new Customer("Ivan", "Ivanov", 18);
        Customer customer2 = new Customer("Petr", "Petrov", 45);
        Customer customer3 = new Customer("Sidr", "Sidorov", 1);
        List customers = Arrays.asList(customer1, customer2, customer3);
        File file = new File("task4.csv");
        fileReading.makeFileFromCustomersList(customers, file);
    }

    /* 1.1.Есть текстовый файл, где каждая строка - целое число:1254554Написать функцию,
    которая принимает имя файла,  возвращает сумму чисел из файла.Подсказка: FileReader, BufferedReader плюс stream API */

    public int readFile(String str) {
        int sum = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(str));) {
            sum = in.lines()
                    .mapToInt(Integer::valueOf)
                    .reduce(0, (i1, i2) -> i1 + i2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sum;
    }

     /* 2. Есть массив строк разной длины. Отсортировать его по длине строк.
    Пример:вход ​{“aaa”, “bbbb”, “a”, ‘bb”}​, выход ​{“a”, “bb”, “aaa”, “bbbb”}​
    . Подсказка:Stream API, sorted, Comparator, lambda functions, Java Doc*/

    public List SortedByStringLength(String str) {

        List sortedLines = new ArrayList();

        try (BufferedReader in = new BufferedReader(new FileReader(str))) {
            sortedLines = in.lines()
                    .sorted(Comparator.comparingInt(String::length))
                    .collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return sortedLines;
    }
    /* 3. Есть текстовый csv файл:“Ivan”, “18”“Piotr”, “20”“Anna”, “10”
    Вывести на экран отсортированный по возрасту список. Подсказка:
    вычитать файлпострочно с  помощью Reader’a, положить данные в список классов  Person,
     списокотсортировать с помощью Stream API.   Можно усложнить - вычитать только тех, кто старше 17 лет.
      Тут разные вариантырешения: вычитать всех, потом отсортировать тех, кто старше 17,
      но если список вфайле большой, то может не стоит создавать объекты в Джаве,
     то есть проверять впроцессе чтения и создавать
     Джава объекты только для тех пользователей, чтостарше 17*/

    public void sortedNamesbyAgeOlder17(String str) {
        try (BufferedReader in = new BufferedReader(new FileReader(str))) {
            in.lines()
                    .filter(p -> checkAge(p) > 17)
                    .map(s -> makePerson(s))
                    .sorted(Comparator.comparingInt(Person::getAge))
                    .forEachOrdered(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int checkAge(String str) {
        String[] lineFromFile = str.split(",");
        return Integer.valueOf(lineFromFile[1]);
    }

    private Person makePerson(String str) {
        String[] lineFromFile = str.split(",");
        return (new Person(lineFromFile[0], Integer.valueOf(lineFromFile[1])));
    }

    //4. Ну и обратная задачка:
    // есть список Customers: firstName, lastName, age
    // -сохранить его в csv файл, похожий на то, что в 3.

    public void makeFileFromCustomersList(List<Customer> input, File file) {
        //try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)), true);)
        try (PrintWriter out = new PrintWriter(file)) {
            input.stream().forEach(p -> out.println(makeLineFromCustomer(p)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String makeLineFromCustomer(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(customer.getFirstname()).append(", ")
                .append(customer.getLastname()).append(", ")
                .append(customer.getAge());
        return new String(sb);
    }
}
