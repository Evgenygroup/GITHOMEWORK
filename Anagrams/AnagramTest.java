package anagrams.as_should_be_but_no_streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static anagrams.as_should_be_but_no_streams.AnagramNew.dictionary;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AnagramTest {

    private AnagramNew a;
    private Map<String, List<String>> dict;


    @Before
    public void init() {
        a = new AnagramNew();
        a.newDictOfAnagrams(dictionary);


    }

    @Test
    public void testAnagramTrue() {
        assertEquals(Arrays.asList("ivan", "vani", "navi"), a.listAnagrams("ivan"));
    }

    @Test
    public void testAnagramTrue2() {
        assertEquals(Arrays.asList("anna", "naan", "nana"), a.listAnagrams("anna"));
    }


    @Test
    public void testAnagramVoid() {
        assertNull(a.listAnagrams(""));
    }


}
