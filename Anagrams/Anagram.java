package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Anagram {

    public List<String> allAnagrams(List<String> list, String string) {
        List<String> res = new ArrayList();
        for (String l : list) {
            if (isAnagram(l, string)) res.add(l);
        }
        return res;
    }

    //O(n log(n))
    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length() || str1.equals(str2)) return false;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);

    }
}

