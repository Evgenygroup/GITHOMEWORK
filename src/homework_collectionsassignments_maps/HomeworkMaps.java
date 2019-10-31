package homework_collectionsassignments_maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkMaps {

    /*1.Дана Map<String, String> map, написать функцию, которая вернет Мап, такую,
    если в есходной map есть ключ ‘a’ и ‘b’, то нужно создать новый ключ ‘ab’ ссуммой значений от ключей a и b.
    Примеры:
    mapAB({"a": "Hi", "b": "There"})  → {"a": "Hi", "ab": "HiThere", "b": "There"}
    mapAB({"a": "Hi"}) → {"a": "Hi"}mapAB({"b": "There"}) → {"b": "There"}

    */

    public Map<String, String> ab(Map<String, String> input) {
        Map<String, String> mapAB = new HashMap();
        if (input.containsKey("a")) mapAB.put("a", input.get("a"));
        if (input.containsKey("b")) mapAB.put("b", input.get("b"));
        if (input.containsKey("a") && input.containsKey("b")) mapAB.put("ab", input.get("a").concat(input.get("b")));
        return mapAB;

    }

    /*2.Дан массив букв, вернуть мапу Map<String, Boolean> где каждая строкаявляется ключем, а значением true,
    если строка в массиве больше одного разаи false, если только один раз.
    Примеры:wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
    wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
    wordMultiple(["c", "c", "c", "c"]) → {"c": true}  */

    public Map<String, Boolean> mapStringBoolean(String[] strings) {
        Map<String, Boolean> ifMoreOne = new HashMap<>();
        for (String s : strings) {
            if (ifMoreOne.containsKey(s)) ifMoreOne.put(s, true);
            else ifMoreOne.put(s, false);
        }
        return ifMoreOne;
    }

    /*4.Дан список имен, где некоторые имена повторяются. Написать функцию,которая по имени вернет количество вхождений
     этого имени в список
     */
    public int nameToNumberOfOccurences(List<String> list, String name) {
        Map<String, Integer> nameToNumberOf = new HashMap();
        for (String s : list) {
            if (nameToNumberOf.containsKey(s)) nameToNumberOf.put(s, nameToNumberOf.get(s) + 1);
            else nameToNumberOf.put(s, 1);

        }
        if (nameToNumberOf.containsKey(name)) return nameToNumberOf.get(name);
        return 0;
    }
}
