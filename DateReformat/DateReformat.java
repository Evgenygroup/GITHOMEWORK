package Dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DateReformat {
    public static void main(String[] args) {

        List<String> dates = Arrays.asList("2019-05-18", "2018-10-25", "2019-07-19");
        System.out.println(reformatDates(dates));

    }

    public static List<String> reformatDates(List<String> input) {

        List<String> formatted = new ArrayList<>();

        for (String l : input) {

            LocalDate parse = LocalDate.parse(l, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String format = parse.format(DateTimeFormatter.ofPattern
                    ("dd MMMM,yyyy EEEE", Locale.US));
            formatted.add(format);
        }
        return formatted;
    }

}
