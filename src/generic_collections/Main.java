package generic_collections;

import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Collection<?> collection = new HashSet<>();
        Object object = new Object();
        //collection.add(object);
        collection.contains(object);
        //collection.addAll(Arrays.asList(object));
        collection.clear();
        collection.remove(object);
        collection.toArray();
        collection.iterator();
        collection.size();
    }
}
