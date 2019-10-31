

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomeworkSetsTest {

    private HomeworkSets homeworkSets;
    List input;

    @Before
    public void init() {
        homeworkSets = new HomeworkSets();
        input = Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");
    }

    @Test
    public void removeDuplicatesOneElement() {
        List<String> actual = Arrays.asList("Ivan");
        List<String> expected = Arrays.asList("Ivan");
        assertEquals(actual, homeworkSets.removeDuplicates(expected));

    }

    @Test
    public void removeDuplicatesNoDoubles() {
        List<String> actual = Arrays.asList("Ivan", "Piotr", "Maria", "Anna");
        List<String> expected = Arrays.asList("Ivan", "Piotr", "Maria", "Anna");

        assertEquals(expected, homeworkSets.removeDuplicates(actual));

    }

    @Test
    public void removeDuplicates() {
        List<String> actual = Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");
        List<String> expected = Arrays.asList("Ivan", "Maria", "Piotr", "Anna");

        assertEquals(expected, homeworkSets.removeDuplicates(actual));

    }

    //2**************************

    @Test
    public void getDuplicatesOneElement() {
        List<String> actual = Arrays.asList("Ivan");
        List<String> expected = Arrays.asList("Ivan");
        assertEquals(actual, homeworkSets.removeDuplicates(expected));

    }

    @Test
    public void getDuplicatesNoDuplicates() {
        List<String> actual = Arrays.asList("Ivan", "Piotr", "Maria", "Anna");
        List<String> expected = Arrays.asList("Ivan", "Piotr", "Maria", "Anna");

        assertEquals(expected, homeworkSets.removeDuplicates(actual));

    }

    @Test
    public void getDuplicatesTest() {
        List<String> actual = Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");
        List<String> expected = Arrays.asList("Maria", "Ivan");

        assertEquals(expected, homeworkSets.getDuplicates(actual));

    }
}
