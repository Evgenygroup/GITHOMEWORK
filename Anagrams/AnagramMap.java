package anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramMap {


    public List<String> allAnagrams(List<String> list, String string) {
        List<String> res = new ArrayList();
        for (String l : list) {
            if (isAnagram(l, string)) res.add(l);
        }
        return res;
    }

    //O(n)
    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length() || str1.equals(str2)) return false;
        Map<Character, Integer> forStr1 = new HashMap();
        Map<Character, Integer> forStr2 = new HashMap();

        for (int i = 0; i < str1.length(); i++) {
            if (forStr1.containsKey(str1.charAt(i))) forStr1.put(str1.charAt(i), forStr1.get(str1.charAt(i)) + 1);
            else forStr1.put(str1.charAt(i), 1);
            if (forStr2.containsKey(str2.charAt(i))) forStr2.put(str2.charAt(i), forStr2.get(str2.charAt(i)) + 1);
            else forStr2.put(str2.charAt(i), 1);
        }
        return forStr1.equals(forStr2);

    }
}
