package improvementscollectionapi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionApiImprovements {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("C", "c");
        map.put("B", "b");
        map.put("Z", "z");

//        Ascending order
        List<Map.Entry<String, String>> sortedByKey = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).toList();
//        Descending order using comparingByValue
        List<Map.Entry<String, String>> sortedByKeyReverse = map.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue().reversed()).toList();

        sortedByKey.forEach(System.out::println);
        System.out.println("\n");
        sortedByKeyReverse.forEach(System.out::println);

        HashMap<String, Integer> map2
                = new HashMap<>();
        map2.put("a", 100);
        map2.put("b", 200);
        map2.put("c", 300);
        map2.put("d", 400);

        // print map details
        System.out.println("HashMap: "
                + map2.toString());

        // provide key whose value has to be obtained
        // and default value for the key. Store the
        // return value in k
        int k = map2.getOrDefault("y", 500);

        // print the value of k returned by
        // getOrDefault(Object key, V defaultValue) method
        System.out.println("Returned Value: " + k);
    }
}
