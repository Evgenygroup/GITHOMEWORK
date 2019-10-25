import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class TransformerTest {


    private Transformer transformer;
    String input;
    Predicate<String> predicate;
    Function<String, String> function;

    @Before
    public void init() {
        transformer = new Transformer();
        input = "aaa BBBB dEF cDkls bbb";
    }


    @Test
    public void testEmpty() {
        input = "";
        predicate = s -> s.length() == 3;
        function = s -> s.toLowerCase();
        assertEquals("", transformer.transforming(input, predicate, function));
    }

    @Test
    public void test3UpperCase() {
        predicate = s -> s.length() == 3;
        function = s -> s.toUpperCase();
        assertEquals("AAA BBBB DEF cDkls BBB", transformer.transforming(input, predicate, function));

    }

    @Test
    public void test4LowerCase() {
        predicate = s -> s.length() == 4;
        function = s -> s.toLowerCase();
        assertEquals("aaa bbbb dEF cDkls bbb", transformer.transforming(input, predicate, function));

    }

    @Test
    public void test5Stars() {
        predicate = s -> s.length() == 5;
        function = s -> s = "*****";
        assertEquals("aaa BBBB dEF ***** bbb", transformer.transforming(input, predicate, function));

    }

    @Test
    public void testNothingChanged() {
        input = "aaa bbbbbbb";
        predicate = s -> s.length() == 4;
        function = s -> s.toUpperCase();
        assertEquals("aaa bbbbbbb", transformer.transforming(input, predicate, function));

    }


}
