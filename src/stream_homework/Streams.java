package stream_homework;

import stream_homework.person_address_account_iban.Address;
import stream_homework.person_address_account_iban.BankAccount;
import stream_homework.person_address_account_iban.Person;
import stream_homework.person_address_account_iban.Person1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    //1 написать функцию, которая по списку persons вернет список адресов техлюдей, чей возраст больше 17 лет.
    
    public List<Address> addressesOlder17(List<Person> input) {
        return input.stream()
                .filter(s -> s.getAge() > 17)
                .map(Person::getAddress)
                .collect(Collectors.toList());
    }

    //2.Есть список имен, нужно написать функцию, которая вернет список имен бездупликатов

    public List<String> namesWithoutDuplicatesWithoutStream(List<String> input) {
        return new ArrayList<String>(new HashSet(input));
    }

    public List<String> namesWithoutDuplicates(List<String> input) {
        Set<String> result = input.stream().collect(Collectors.toSet());
        return new ArrayList<>(result);

    }

    //3. Есть список людей, нужно написать функцию,
    // которая вернет мапу, гдеключом является возраст,
    // а значением список людей этого возраста.

    public Map<Integer, List<Person>> personByAge(List<Person> input) {
        return input.stream().collect(Collectors.groupingBy(Person::getAge));
    }

    //4. Есть два класса:public class BankAccount {  String IBANN;  Person owner;}
    // public class Person {  String name;}нужно написать функцию,
    // которая возвращает мапу, где значением является Person, азначением - список его банковских счетов.

    public Map<Person, List<BankAccount>> personToAccountList(List<BankAccount> input) {
        return input.stream().collect(Collectors.groupingBy(BankAccount::getOwner));

    }

    //5. Написать функцию, которая для списка счетов,
    // возвращает список IBANNs,где в каждом IBANN символы после 3-го и до конца заменены звездочками

    public List<String> iBansWithStars(List<BankAccount> input) {
        return input.stream()
                .map(s -> ibanReplaceLetters(s.getIban()))
                .collect(Collectors.toList());

    }

    private String ibanReplaceLetters(String str) {
        char[] chars = str.toCharArray();
        for (int i = 3; i < str.length(); i++) chars[i] = '*';
        return new String(chars);
    }

    //6. Написать функцию, которая принимает предложение,
    // а возвращает количество слов, начинающихся на заданную букву

    public long numberOfWords(String sentence, char letter) {
        return Stream.of(sentence.split("[, ]"))
                .filter(s -> s.charAt(0) == letter)
                .count();

    }

    //  7. Написать функцию, которая
    //  проверяет, является ли заданная строка целымчислом.
    //     Подсказка - Character.isDigit() и Stream.allMatch()

    public boolean stringIsDigit(String string) {
        return string.chars().allMatch(Character::isDigit);

    }

    //  8-9. Написать функцию, которая по списку persons
    //  возвращает список ихбанковских счетов с звездочками с третьего символа. Подсказка - flatMap()

    public List<String> accountsListWithStars(List<Person1> input) {
        return input.stream()
                .flatMap(ba -> ba.getBankAccounts().stream())
                .map(ib -> ib.getIban())
                .map(ib -> ibanReplaceLetters(ib))
                .collect(Collectors.toList());

    }

    //  10. Для списка persons посчитать общий возраст тех, кому больше 17 лет.Подсказка - reduce()

    public int more17Age(List<Person> input) {
        return input.stream()
                .map(Person::getAge)
                .filter(p -> p > 17)
                // .reduce(0,(a1,a2)->a1+a2)
                .reduce(0, Integer::sum);

    }


    //11. Написать функцию, которая для списка persons напечатает для тех, ктостарше 17 лет:
    // In Germany <name1> and <name2> and ...<nameN> are of legalage. Подсказка - Collectors.joining();

    public String legalAge(List<Person> input) {
        return input.stream()
                .filter(p -> p.getAge() > 17)
                .map(Person::getName)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age"));
    }


}



