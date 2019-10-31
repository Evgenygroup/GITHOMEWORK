package collections_homework_lists;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomeworkListTest {
    private HomeworkkList homeworkkList = new HomeworkkList();

    @Before
    public void init() {
        homeworkkList = new HomeworkkList();
    }

    //1
    @Test
    public void getAddressesTestEmpty() {
        assertEquals(Arrays.asList(), homeworkkList.getAddresses(Arrays.asList()));
    }

    @Test
    public void getAddressesTestOne() {
        Address address = new Address("Street1", 1);
        Person person = new Person("Person1", address);
        List<Address> expected = Arrays.asList(address);
        List<Person> actual = Arrays.asList(person);

        assertEquals(expected, homeworkkList.getAddresses(actual));
    }

    @Test
    public void getAddressesTestSeveral() {

        Address address1 = new Address("Street1", 1);
        Address address2 = new Address("Street2", 2);
        Person person1 = new Person("Person1", address1);
        Person person2 = new Person("Person2", address2);
        List<Address> expected = Arrays.asList(address1, address2);
        List<Person> actual = Arrays.asList(person1, person2);


        assertEquals(expected, homeworkkList.getAddresses(actual));
    }

    //2********************************

    @Test
    public void listwithoutNamesLength4Test() {
        List<String> expected = Arrays.asList("Maria", "Stephan", "Amalia");
        List<String> actual = Arrays.asList("Ivan", "Maria", "Stephan", "John", "Amalia");
        assertEquals(expected, homeworkkList.listwithoutNamesLength4(actual));
    }


    //3********************************

    @Test
    public void yesOrNoTestEmpty() {
        assertEquals(Arrays.asList(), homeworkkList.YesOrNo(Arrays.asList(), Arrays.asList()));

    }

    @Test
    public void yesOrNoTestOneElement() {

        List<String> expected = Arrays.asList("No");

        List<Integer> actual1 = Arrays.asList(1);
        List<Integer> actual2 = Arrays.asList(5);
        assertEquals(expected, homeworkkList.YesOrNo(actual1, actual2));
    }

    @Test
    public void yesOrNoTest() {
        List<String> expected = Arrays.asList("No", "Yes", "Yes", "No");
        List<Integer> actual1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> actual2 = Arrays.asList(5, 2, 3, 8);
        assertEquals(expected, homeworkkList.YesOrNo(actual1, actual2));
    }


    //5**************************************

    @Test
    public void reversedEmpty() {
        assertEquals(Arrays.asList(), homeworkkList.reversed(Arrays.asList()));
    }

    @Test
    public void reversedOne() {
        assertEquals(Arrays.asList(1), homeworkkList.reversed(Arrays.asList(1)));
    }

    @Test
    public void reversedListTest() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> actual = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expected, homeworkkList.reversed(actual));
    }


    //6********************************************

    @Test
    public void joinTwoListsTestEmpty() {
        assertEquals(Arrays.asList(), homeworkkList.joinTwoLists(Arrays.asList(), Arrays.asList()));
    }

    @Test
    public void joinTwoListsTestOneelement() {
        assertEquals(Arrays.asList(1, 2), homeworkkList.joinTwoLists(Arrays.asList(1), Arrays.asList(2)));
    }

    @Test
    public void joinTwoListsTest() {

        List<String> names = Arrays.asList("Ivan", "Maria", "Stephan", "John", "Amalia");
        List<String> add = Arrays.asList("Add1", "Add2");

        List<String> expected = Arrays.asList("Ivan", "Maria", "Stephan", "John", "Amalia", "Add1", "Add2");

        assertEquals(expected, homeworkkList.joinTwoLists(names, add));
    }


    //7**********************************************

    @Test
    public void withoutelementsMoreThanRequiredEmpty() {
        List<Integer> expected = Arrays.asList();
        List<Integer> actual = Arrays.asList();
        assertEquals(expected, homeworkkList.withoutelementsMoreThanRequired(actual, 4));
    }

    @Test
    public void withoutelementsMoreThanRequiredOneelement() {
        List<Integer> expected = Arrays.asList(1);
        List<Integer> actual = Arrays.asList(1);
        assertEquals(expected, homeworkkList.withoutelementsMoreThanRequired(actual, 4));
    }

    @Test
    public void withoutelementsMoreThanRequiredNoSuchElements() {
        List<Integer> expected = Arrays.asList();
        List<Integer> actual = Arrays.asList(3, 1, 8, 2);
        assertEquals(expected, homeworkkList.withoutelementsMoreThanRequired(actual, 0));
    }

    @Test
    public void withoutelementsMoreThanRequired() {
        List<Integer> expected = Arrays.asList(1, 5, 3, 2);
        List<Integer> actual = Arrays.asList(1, 5, 3, 9, 2);
        assertEquals(expected, homeworkkList.withoutelementsMoreThanRequired(actual, 8));
    }


}
