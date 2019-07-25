package Dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DateReformatString {

    public static void main(String[] args) {


        List<String> dates = Arrays.asList("2019-05-18", "2018-10-25", "2019-07-19");
        System.out.println(reformatDates(dates));


    }


    public static List<String> reformatDates(List<String> input) {

        List<String> reformatedDate = input
                .stream()
                .map(LocalDate::parse)
                .map(s -> s.format(DateTimeFormatter.ofPattern
                        ("dd MMMM,yyyy EEEE", Locale.ENGLISH)))
                .collect(Collectors.toList());

        return reformatedDate;

    }


}


