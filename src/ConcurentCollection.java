import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurentCollection {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("");

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("");

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();

        Set set = Collections.newSetFromMap(concurrentHashMap);

    }

}
