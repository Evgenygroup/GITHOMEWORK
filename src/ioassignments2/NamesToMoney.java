package ioassignments2;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class NamesToMoney {
  /*  Задача 2 Есть файл:
    Sergey,Lukichev,Notebook Lenovo,500
    Piotr,Ivanov,Apple MacBook,800
    Sergey,Lukichev,Keyboard Cherry,25
    Ivan,Petrov,Mouspad,5
    Piotr,Ivanov,Apple Touchpad,60
    То есть список имен с оборудованием и оценочной стоимостью.
    Имена могутповторяться. Нужно написать программу, которая вернет файл с
    отсортированным посумме списком
   имен и суммой по стоимости для каждого человека:
   Ivan Petrov,5Sergey Lukichev,525Piotr Ivanov,860
   */


    public static void main(String[] args) {
        NamesToMoney n = new NamesToMoney();
        n.namesSortedByCost(new File("list.csv"), new File("listout.csv"));

    }

    public void namesSortedByCost(File source, File dest) {
        try (BufferedReader in = new BufferedReader(new FileReader(source)); PrintWriter out = new PrintWriter(dest)) {
            Map<String, Integer> personByCost = in.lines()
                    .map(s -> makePerson(s))
                    .collect(Collectors.groupingBy(Person::getLastname, Collectors.summingInt(Person::getCost)));

            personByCost
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt(s -> s.getValue()))
                    .forEach(entry -> out.println(entry.getKey() + ", " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Person makePerson(String str) {
        String[] data = str.split(",");
        return (new Person(data[0], data[1], Integer.valueOf(data[3])));
    }


}

class Person {
    private String firstName;
    private String lastname;
    private int cost;

    public Person(String firstName, String lastname, int cost) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.cost = cost;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getCost() {
        return cost;
    }
}
