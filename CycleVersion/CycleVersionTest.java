import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import java.util.List;

import static org.junit.Assert.*;

public class CycleVersionTest {

    private CycleVersion c;

    @Before
    public void init() {
        c = new CycleVersion();
    }

    @Test
    public void empty() {
        List<String> list1 = Arrays.asList();
        List<String> list2 = Arrays.asList();
        assertTrue(c.isCycle(list1, list2));
    }

    @Test
    public void same() {
        List<String> list1 = Arrays.asList("aa", "bb", "cc", "dd");
        assertTrue(c.isCycle(list1, list1));
    }

    @Test
    public void wrongSize() {
        List<String> list1 = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> list2 = Arrays.asList("bb", "cc", "dd");
        assertFalse(c.isCycle(list1, list2));
    }

    @Test
    public void simpleTrue() {
        List<String> list1 = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> list2 = Arrays.asList("bb", "cc", "dd", "aa");
        assertTrue(c.isCycle(list1, list2));
    }

    @Test
    public void simpleFalse() {
        List<String> list1 = Arrays.asList("dd", "ee", "ff");
        List<String> list2 = Arrays.asList("dd", "ff", "ee");
        assertFalse(c.isCycle(list1, list2));
    }

}
