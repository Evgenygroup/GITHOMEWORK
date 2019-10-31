

import java.util.*;

public class HomeworkSets {
   /* 1.С использованием множеств (Set) реализовать функцию, которая вернет списокбез повторяющихся элементов:
    List<String> removeDuplicates(List<String> input)
    Пример:​ {“Ivan”, “Maria”, “Piotr”, “Anna”, “Maria”, “Ivan”} -> {“Ivan”, “Maria”, “Piotr”,“Anna”}
    2.С использованием множеств реализовать функцию, которая вернетповторяющиеся элементы из данного списка:
    List<String>
    getDuplicates(List<String> input)
    Пример: ​ {“Ivan”, “Maria”, “Piotr”, “Anna”, “Maria”, “Ivan”} -> {“Ivan”, “Maria”}*/

    public List removeDuplicates(List<String> input) {
        Set set = new HashSet(input);
        return new ArrayList(set);
    }

    public List getDuplicates(List<String> input) {
        Set set = new HashSet();
        List duplicates = new ArrayList();
        for (String s : input) {
            if (!set.add(s)) duplicates.add(s);
        }
        return duplicates;

    }

}
