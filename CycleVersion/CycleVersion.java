
import java.util.LinkedList;
import java.util.List;

public class CycleVersion {


    /*Есть два списка с буквами. Определить, является ли один список циклическойверсией другого. Например,
    для списков {aa, bb, cc, dd} и {cc, dd, aa, bb}результат
    будет true, а для {dd, ee, ff} и {dd, ff, ee} - false*/

    public boolean isCycle(List list1, List list2) {
        LinkedList list1Copy = new LinkedList(list1);

        if (list1.equals(list2)) return true;
        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            list1Copy.addFirst(list1Copy.removeLast());
            if (list1Copy.equals(list2)) return true;
        }
        return false;
    }

}
