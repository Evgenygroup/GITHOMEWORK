package stream_homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stream_homework.person_address_account_iban.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StreamsTest {
    private stream_homework.Streams s;

    @Before
    public void init() {
        s = new Streams();
    }

    //1
    @Test
    public void addressesOlder17TestOneElement() {

        Address address1 = new Address("Str1", 34);
        Person person1 = new Person("Ivan", 23, address1);
        List<Person> actual = Arrays.asList(person1);
        List<Address> expected = Arrays.asList(address1);

        assertEquals(expected, s.addressesOlder17(actual));

    }

    @Test
    public void addressesOlder17TestNoPersonsOlder17() {

        Address address1 = new Address("Str1", 34);
        Address address2 = new Address("Str2", 36);
        Person person1 = new Person("Ivan", 16, address1);
        Person person2 = new Person("Petr", 13, address2);
        List<Person> actual = Arrays.asList(person1, person2);
        List<Address> expected = Arrays.asList();

        assertEquals(expected, s.addressesOlder17(actual));

    }

    @Test
    public void addressesOlder17TestCorrect() {

        Address address1 = new Address("Str1", 34);
        Address address2 = new Address("Str2", 36);
        Address address3 = new Address("Str3", 3);
        Person person1 = new Person("Ivan", 18, address1);
        Person person2 = new Person("Petr", 17, address2);
        Person person3 = new Person("Nick", 56, address3);
        List<Person> actual = Arrays.asList(person1, person2, person3);
        List<Address> expected = Arrays.asList(address1, address3);

        assertEquals(expected, s.addressesOlder17(actual));

    }

    //2
    @Test
    public void namesWithoutDuplicatesOneElement() {
        List expected = Arrays.asList("Ivan");
        List actual = Arrays.asList("Ivan");

        assertEquals(expected, s.namesWithoutDuplicates(actual));
    }

    @Test
    public void namesWithoutDuplicatesNoduplicates() {
        List expected = Arrays.asList("Ivan", "Maria", "Piotr", "Anna");
        List actual = Arrays.asList("Ivan", "Maria", "Piotr", "Anna");

        assertEquals(expected, s.namesWithoutDuplicates(actual));


    }

    @Test
    public void namesWithoutDuplicatesCorrect() {
        List expected = Arrays.asList("Ivan", "Maria", "Piotr", "Anna");
        List actual = Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");

        assertEquals(expected, s.namesWithoutDuplicates(actual));
    }

    //3
    @Test
    public void personByAgeTest() {

        Address address = null;

        Person person1 = new Person("Ivan", 18, address);
        Person person6 = new Person("Alex", 18, address);
        Person person2 = new Person("Elena", 17, address);
        Person person3 = new Person("Petr1", 17, address);
        Person person4 = new Person("Nick", 56, address);
        Person person5 = new Person("Petr2", 18, address);
        List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5, person6);
        List<Person> person17 = Arrays.asList(person2, person3);
        List<Person> persons18 = Arrays.asList(person1, person5, person6);
        List<Person> person56 = Arrays.asList(person4);

        Map<Integer, List<Person>> expected = new HashMap<>();
        expected.put(18, persons18);
        expected.put(17, person17);
        expected.put(56, person56);


        assertEquals(expected, s.personByAge(persons));

    }

    //4
    @Test
    public void personToAccountListTest() {
        Person p1 = new Person("Ivanov", 20, null);
        Person p2 = new Person("Petrov", 20, null);
        Person p3 = new Person("Sidorov", 20, null);

        BankAccount acc1 = new BankAccount("DE76370400440532013000", p1);
        BankAccount acc2 = new BankAccount("DE23760419444839053718", p3);
        BankAccount acc3 = new BankAccount("DE45370400440532013067", p2);
        BankAccount acc4 = new BankAccount("DE81760408741587013019", p1);
        BankAccount acc5 = new BankAccount("DE89970453440523013096", p3);
        List<BankAccount> list = Arrays.asList(acc1, acc2, acc3, acc4, acc5);

        Map<Person, List<BankAccount>> expected = new HashMap<>();
        expected.put(p1, Arrays.asList(acc1, acc4));
        expected.put(p2, Arrays.asList(acc3));
        expected.put(p3, Arrays.asList(acc2, acc5));


        assertEquals(expected, s.personToAccountList(list));
    }

    //5.
    @Test
    public void ibanReplaceLettersTest() {

        Person p1 = new Person("Ivanov", 20, null);
        Person p2 = new Person("Petrov", 20, null);
        Person p3 = new Person("Sidorov", 20, null);

        BankAccount acc1 = new BankAccount("DE76370400440532013000", p1);
        BankAccount acc2 = new BankAccount("DE23760419444839053718", p3);
        BankAccount acc3 = new BankAccount("DE45370400440532013067", p2);
        List<BankAccount> actual = Arrays.asList(acc1, acc2, acc3);
        List<String> expected = Arrays.asList("DE7*******************",
                "DE2*******************", "DE4*******************");

        assertEquals(expected, s.iBansWithStars(actual));

    }

    //6
    @Test
    public void numberOfWordsTest0() {
        String sentence = "aaaaaaaa fffffff aa bbbb a bbb,aaa ggggggggggg";
        assertEquals(0, s.numberOfWords(sentence, 'k'));
    }

    @Test
    public void numberOfWordsOneTest() {
        String sentence = "aaaaa";
        assertEquals(1, s.numberOfWords(sentence, 'a'));
    }

    @Test
    public void numberOfWordsTest1() {
        String sentence = "aaaaaaaa fffffff aa bbbb a bbb,aaa ggggggggggg";
        assertEquals(1, s.numberOfWords(sentence, 'f'));
    }

    @Test
    public void numberOfWordsTest4() {
        String sentence = "aaaaaaaa fffffff aa bbbb a bbb,aaa ggggggggggg";
        assertEquals(4, s.numberOfWords(sentence, 'a'));
    }

    //7
    @Test
    public void stringIsDigitTestTrue() {
        String test = "1459032";
        assertTrue(s.stringIsDigit(test));

    }

    @Test
    public void stringIsDigitTestFalse() {
        String test = "adf45";
        Assert.assertFalse(s.stringIsDigit(test));

    }

    //8-9
    @Test
    public void accountsListWithStarsTest() {
        BankAccount1 acc1 = new BankAccount1("DE76370400440532013000");
        BankAccount1 acc2 = new BankAccount1("DE23760419444839053718");
        BankAccount1 acc3 = new BankAccount1("DE45370400440532013067");
        BankAccount1 acc4 = new BankAccount1("DE81760408741587013019");
        BankAccount1 acc5 = new BankAccount1("DE89970453440523013096");

        List<BankAccount1> ba1 = Arrays.asList(acc1, acc2);
        List<BankAccount1> ba2 = Arrays.asList(acc3, acc4);
        List<BankAccount1> ba3 = Arrays.asList(acc5);

        Person1 personA = new Person1("Ivanov", ba2);
        Person1 personB = new Person1("Petrov", ba1);
        Person1 personC = new Person1("Sidorov", ba3);
        List<String> expected = Arrays.asList("DE4*******************",
                "DE8*******************",
                "DE7*******************",
                "DE2*******************",
                "DE8*******************");
        List<Person1> actual = Arrays.asList(personA, personB, personC);

        assertEquals(expected, s.accountsListWithStars(actual));

    }

    @Test
    public void accountsListWithStarsTestOne() {
        BankAccount1 acc1 = new BankAccount1("DE76370400440532013000");

        List<BankAccount1> ba1 = Arrays.asList(acc1);
        Person1 personB = new Person1("Petrov", ba1);

        List<String> expected = Arrays.asList("DE7*******************");
        List<Person1> actual = Arrays.asList(personB);

        assertEquals(expected, s.accountsListWithStars(actual));

    }
    //10

    @Test
    public void more17AgeTestNoElements() {
        List<Person> persons = Arrays.asList();
        assertEquals(0, s.more17Age(persons));
    }

    @Test
    public void more17AgeTestOnePerson() {
        Address address = null;
        Person person1 = new Person("Ivan", 18, address);

        List<Person> persons = Arrays.asList(person1);
        assertEquals(18, s.more17Age(persons));

    }

    @Test
    public void more17AgeTestOnePerson17() {
        Address address = null;
        Person person1 = new Person("Ivan", 17, address);

        List<Person> persons = Arrays.asList(person1);
        assertEquals(0, s.more17Age(persons));

    }


    @Test
    public void more17AgeTest() {
        Address address = null;
        Person person1 = new Person("Ivan", 18, address);
        Person person6 = new Person("Alex", 18, address);
        Person person2 = new Person("Elena", 17, address);
        Person person3 = new Person("Petr1", 15, address);
        Person person4 = new Person("Nick", 56, address);
        Person person5 = new Person("Petr2", 18, address);
        List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5, person6);

        assertEquals(110, s.more17Age(persons));

    }

    //11
    @Test
    public void legalAgeTest() {
        Address address = null;
        Person person1 = new Person("Ivan", 18, address);
        Person person6 = new Person("Alex", 18, address);
        Person person2 = new Person("Elena", 17, address);
        Person person3 = new Person("Petr1", 15, address);
        Person person4 = new Person("Nick", 56, address);
        Person person5 = new Person("Petr2", 18, address);
        List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5, person6);

        assertEquals("In Germany Ivan and Nick and " +
                "Petr2 and Alex are of legal age", s.legalAge(persons));

    }


}
