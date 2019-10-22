package max_occurency;

import java.util.*;

public class Map5 {
    /*  Дан текст, подсчитать, какое слово встречается больше остальных.
  Слова впредложениях могут разделяться запятыми, точками, пробелами.
  Предлоги [в,на, из, под] и остальные не учитывать при подсчете.*/

    static List prepositions = Arrays.asList(
            "and", "about", "above", "across", "after", "with",
            "around", "as", "at", "behind", "below",
            "beneath", "beside", "between", "beyond",
            "but", "by", "in", "is", "into", "on", "over",
            "to", "a", "under");


    public String result(String string) {

        List<String> split = splitSentence(string);
        return maxOccurency(split);
    }

    private String maxOccurency(List<String> list) {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (res.containsKey(list.get(i))) res.put(list.get(i), res.get(list.get(i)) + 1);
            else res.put(list.get(i), 1);
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) maxEntry = entry;
            //entry.getValue().compareTo(maxEntry.getValue())>0
        }
        return maxEntry.getKey();

    }

    private List<String> splitSentence(String string) {
        String[] splitted = string.split("[,. ]");
        boolean flag = true;
        List<String> dict = new ArrayList();

        for (int i = 0; i < splitted.length; i++) {
            for (int j = 0; j < prepositions.size(); j++) {
                if ((splitted[i].toLowerCase().equals(prepositions.get(j)))) {
                    flag = false;
                    break;
                }
            }

            if (flag) dict.add(splitted[i].toLowerCase());
            flag = true;
        }
        if (dict.isEmpty()) throw new DictionaryIsEmptyException("Text is empty or only prepositions in the text");
        return dict;
    }

}

