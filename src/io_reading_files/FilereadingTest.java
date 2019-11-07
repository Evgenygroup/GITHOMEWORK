package io_reading_files;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilereadingTest {
    private FileReading fileReading;

    @Before
    public void init() {
        fileReading = new FileReading();
    }

    @Test
    public void readFileTest() {
        assertEquals(107, fileReading.readFile("text.txt"));
    }


    @Test
    public void sortebyStringlengthTest() {
        List<String> expected = Arrays.asList("a", "bb", "aaa", "bbbb");
        assertEquals(expected, fileReading.SortedByStringLength("array.txt"));
    }

}
