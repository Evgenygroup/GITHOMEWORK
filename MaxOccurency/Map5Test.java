package max_occurency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Map5Test {
    private Map5 m;


    @Before
    public void init() {
        m = new Map5();
    }

    @Test
    public void testTrue() {
        String text = "This  is A sample sentence with several words." +
                "This is another sample,sentence with several different words and words";
        assertEquals("words", m.result(text));


    }

    @Test(expected = DictionaryIsEmptyException.class)
    public void testEmptyText() {
        String text = " ";
        m.result(text);


    }

    @Test(expected = DictionaryIsEmptyException.class)
    public void testOnlyPrepositions() {
        String text = "at,behind ";
        m.result(text);


    }

    @Test
    public void testTrueCapitalLetters() {
        String text = " Words.several Words and several words";
        assertEquals("words", m.result(text));


    }

}
