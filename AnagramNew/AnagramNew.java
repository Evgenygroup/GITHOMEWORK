

import java.util.*;

/*3.Анаграмма слова x  - слово, по длине равное x и состоящее из таких же букв,что и x.
Например, слово “vani” является анаграммой слова “ivan”, а слова“naan” и “anan”
являются анаграммами слова “anna”. Дан словарь, сожержащийанаграммы,
например {“anna”, “ivan”, “naan”, “vani”, “piotr”, “nana”, “navi”}.
Написать функцию, которая по слову из словаря вернет все анаграммы этогослова,
которые есть в словаре. Например, по слову “ivan” функция вернет{“navi”, “vani”} */

public class AnagramNew {

    static String[] dictionary = {"anna", "ivan", "naan", "vani", "pyotr", "nana", "navi"};
    Map<String, List<String>> createDict = new HashMap<>();


    public List<String> listAnagrams(String word) {
        String sorting = sorting(word);
        return createDict.get(sorting);

    }

    public void newDictOfAnagrams(String[] str) {

        for (String s : str) {
            String sorting = sorting(s);

            List<String> values = createDict.get(sorting);
            if (values == null) values = new ArrayList<>();
            values.add(s);
            createDict.put(sorting, values);

        }

    }


    private String sorting(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
