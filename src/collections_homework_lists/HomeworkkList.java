package collections_homework_lists;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeworkkList {

     /*1 Есть два класса: Address с полями улица и номер дома и Person с полями имя иAddress.
    Нужно написать функцию:List<Address> getAddresses(List<Person> persons)
    то есть по списку persons возвращать список их адресов*/

    public List<Address> getAddresses(List<Person> persons) {
        List<Address> returnAddress = new ArrayList<>();
        for (Person p : persons) returnAddress.add(p.getAddress());
        return returnAddress;
    }


    /*2.Есть список с именами: ​Ivan, Maria, Stephan, John, Amalia​. Написать функцию,которая вернет список,
    в котором не содержатся имена исходного списка,длиной 4. */
    public List<String> listwithoutNamesLength4(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.length() != 4) result.add(s);
        }
        return result;
    }

     /*3. Есть два списка одинаковой длины с числами.
    Написать функцию, котораявернет список с элементами Yes или No,
    где значение на i-том месте зависит оттого, равны ли элементы двух списков под номером i.
        Например, {1, 2, 3, 4} и {5,2, 3, 8} вернет {No, Yes, Yes, No}*/

    public List<String> YesOrNo(List<Integer> list1, List<Integer> list2) {
        List<String> resultYesNo = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) == list2.get(i)) resultYesNo.add("Yes");
            else resultYesNo.add("No");
        }
        return resultYesNo;
    }

    // 5.Написать функцию, которая реверсирует список, возвращает список элементовв обратном порядке.
    // {1, 2, 3, 4, 5} -> {5, 4, 3, 2, 1}

    public List<Integer> reversed(List<Integer> list) {
        Collections.reverse(list);
        return list;
    }

    // 6.Объединить два списка в один.

    public List joinTwoLists(List list1, List list2) {
        List joined = new ArrayList(list1.size() + list2.size());
        joined.addAll(list1);
        joined.addAll(list2);
        return joined;
    }


    /*7.Есть список с целыми числами. Написать функцию, которая вернет список безэлементов, больше заданного.*/

    public List<Integer> withoutelementsMoreThanRequired(List<Integer> input, int n) {
        List<Integer> withoutMoreThan = new ArrayList<>();
        for (Integer i : input) {
            if (i <= n) withoutMoreThan.add(i);
        }
        return withoutMoreThan;
    }

}
