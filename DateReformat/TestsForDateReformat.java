package Tests;

import Dates.DateReformat;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestsForDateReformat {

    @Test
    public void testDateReformat() {
        List<String> dates = Arrays.asList("2019-05-18", "2018-10-25", "2019-07-19");
        List<String> pattern = Arrays.asList("18 May,2019 Saturday", "25 October,2018 Thursday",
                "19 July,2019 Friday");

        List<String> testStrings = DateReformatString.reformatDates(dates);
        assertEquals(pattern, testStrings);
    }


}
