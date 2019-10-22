

import java.util.*;

public class AnagramNew {

    static String[] dictionary = {"anna", "ivan", "naan", "vani", "pyotr", "nana", "navi"};

    public static void main(String[] args) {
        AnagramNew a = new AnagramNew();
        Map<String, List<String>> dict = a.NewDictOfAnagrams(AnagramNew.dictionary);
        System.out.println(a.ListAnagrams(dict, "ivan"));
    }


    public List<String> ListAnagrams(Map<String, List<String>> map, String word) {
        String sorting = sorting(word);
        return map.get(sorting);

    }

    public Map<String, List<String>> NewDictOfAnagrams(String[] str) {
        Map<String, List<String>> Dict = new HashMap<>();
        for (String s : str) {
            String sorting = sorting(s);

            List<String> values = Dict.get(sorting);
            if (values == null) values = new ArrayList<>();
            values.add(s);
            Dict.put(sorting, values);

        }
        return Dict;
    }


    public String sorting(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
