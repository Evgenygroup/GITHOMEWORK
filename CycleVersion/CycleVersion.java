import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleVersion {


    /*Есть два списка с буквами. Определить, является ли один список циклическойверсией другого. Например,
    для списков {aa, bb, cc, dd} и {cc, dd, aa, bb}результат
    будет true, а для {dd, ee, ff} и {dd, ff, ee} - false*/

    public boolean isCycle(List list1, List list2) {
        if (list1.equals(list2)) return true;
        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            if (rotateOnce(list1).equals(list2)) return true;
        }
        return false;
    }

    private List<String> rotateOnce(List<String> list) {
        String buff = list.get(list.size() - 1);
        for (int i = list.size() - 1; i > 0; i--) list.set(i, list.get(i - 1));
        list.set(0, buff);
        return list;
    }
}
