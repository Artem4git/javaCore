package generic_collections._6_2_13;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        System.out.println(symmetricDifference(set1, set2));

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        //твой код здесь
        Set setFor1 = new HashSet<>(set1);
        Set setFor2 = new HashSet<>(set2);
        setFor1.removeAll(set2);
        setFor2.removeAll(set1);
        setFor2.addAll(setFor1);
        return (Set<T>) setFor2;
    }
}
