package homework_collectionsassignments_maps;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HomeworkMapsTests {
    private HomeworkMaps homeworkMaps = new HomeworkMaps();

    @Before
    public void init() {
        homeworkMaps = new HomeworkMaps();
    }

    //1******************************
    @Test
    public void AbTestTrue() {

        Map<String, String> input = new HashMap();
        input.put("a", "Hi");
        input.put("b", "There");
        Map<String, String> expected = new HashMap<>();
        expected.put("a", "Hi");
        expected.put("b", "There");
        expected.put("ab", "HiThere");

        assertEquals(expected, homeworkMaps.ab(input));
    }

    @Test
    public void AbTestNoA() {
        Map<String, String> input = new HashMap();
        input.put("c", "Hi");
        input.put("b", "There");
        Map<String, String> expected = new HashMap<>();
        expected.put("b", "There");

        assertEquals(expected, homeworkMaps.ab(input));
    }

    @Test
    public void AbTestNoB() {
        Map<String, String> input = new HashMap();
        input.put("a", "Hi");
        Map<String, String> expected = new HashMap<>();
        expected.put("a", "Hi");

        assertEquals(expected, homeworkMaps.ab(input));
    }

    //2***************************
    @Test
    public void mapStringBooleanTrue() {
        String[] wordMultiple = new String[]{"a", "b", "a", "c", "b"};
        Map<String, Boolean> expected = new HashMap<>();
        expected.put("a", true);
        expected.put("b", true);
        expected.put("c", false);

        assertEquals(expected, homeworkMaps.mapStringBoolean(wordMultiple));

    }

    @Test
    public void mapStringBooleanTrueAllLettersTheSame() {
        String[] wordMultiple = new String[]{"c", "c", "c", "c"};
        Map<String, Boolean> expected = new HashMap<>();
        expected.put("c", true);

        assertEquals(expected, homeworkMaps.mapStringBoolean(wordMultiple));
    }

    @Test
    public void mapStringBooleanTrueAllFalse() {
        String[] wordMultiple = new String[]{"a", "b", "c"};
        Map<String, Boolean> expected = new HashMap<>();
        expected.put("a", false);
        expected.put("b", false);
        expected.put("c", false);

        assertEquals(expected, homeworkMaps.mapStringBoolean(wordMultiple));
    }

    //4**********************************

    @Test
    public void nameToNumberOfOccurences2() {
        List input = Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");

        assertEquals(2, homeworkMaps.nameToNumberOfOccurences(input, "Ivan"));
    }

    @Test
    public void nameToNumberOfOccurences1() {
        List input = Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");

        assertEquals(1, homeworkMaps.nameToNumberOfOccurences(input, "Piotr"));
    }

    @Test
    public void nameToNumberOfOccurences0() {
        List input = Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");

        assertEquals(0, homeworkMaps.nameToNumberOfOccurences(input, "Semen"));
    }

    @Test
    public void nameToNumberOfOccurencesOnly2Ivans() {
        List input = Arrays.asList("Ivan", "Ivan");

        assertEquals(2, homeworkMaps.nameToNumberOfOccurences(input, "Ivan"));
    }

    @Test
    public void nameToNumberOfOccurencesemptyList() {
        List input = Arrays.asList();

        assertEquals(0, homeworkMaps.nameToNumberOfOccurences(input, "Semen"));
    }


}
