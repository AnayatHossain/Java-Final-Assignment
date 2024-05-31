import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");
        stringList.add("grape");

        System.out.println("Original list: " + stringList);

        removeDuplicates(stringList);

        System.out.println("List after removing duplicates: " + stringList);
    }

    public static void removeDuplicates(List<String> list) {
        Set<String> seen = new HashSet<>();
        int writeIndex = 0;

        for (String str : list) {
            if (!seen.contains(str)) {
                seen.add(str);
                list.set(writeIndex++, str);
            }
        }

        list.subList(writeIndex, list.size()).clear();
    }
}
