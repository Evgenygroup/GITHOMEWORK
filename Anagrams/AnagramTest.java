package anagrams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class AnagramTest {

    private AnagramMap anagram;

    @Before
    public void init() {
        anagram = new AnagramMap();

    }


    @Test
    public void testTrue1() {
        List<String> dict = Arrays.asList("anna", "ivan", "naan", "vani", "piotr", "nana", "navi");
        assertEquals(Arrays.asList("vani", "navi"), anagram.allAnagrams(dict, "ivan"));

    }

    @Test
    public void testTrue2() {
        List<String> dict = Arrays.asList("anna", "ivan", "naan", "vani", "piotr", "nana", "navi");
        assertEquals(Arrays.asList("naan", "nana"), anagram.allAnagrams(dict, "anna"));


    }

    @Test
    public void testNoAnagrams() {
        List<String> dict = Arrays.asList("anna", "ivan", "naan", "vani", "piotr", "nana", "navi");
        assertEquals(Arrays.asList(), anagram.allAnagrams(dict, "piotr"));


    }

    @Test
    public void testMisspelledAnagram() {
        List<String> dict = Arrays.asList("anna", "ivan", "naan", "vani", "piotr", "nana", "navi");
        assertEquals(Arrays.asList(), anagram.allAnagrams(dict, "ann"));


    }

    @Test
    public void testDoubleLetter() {
        List<String> dict = Arrays.asList("anna", "ivan", "naan", "vani", "piotr", "nana", "navi");
        assertEquals(Arrays.asList(), anagram.allAnagrams(dict, "ivvan"));


    }

    @Test
    public void testVoid() {
        List<String> dict = Arrays.asList("anna", "ivan", "naan", "vani", "piotr", "nana", "navi");
        assertEquals(Arrays.asList(), anagram.allAnagrams(dict, ""));
    }


}


