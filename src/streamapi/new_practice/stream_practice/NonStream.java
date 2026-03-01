package streamapi.new_practice.stream_practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonStream {
    public void frequencyOfEachCharacter(String input) {
        input.chars().distinct().forEach(
                element -> {
                    long count = input.chars().filter(ch -> ch == element).count();
                    System.out.println((char) element + " = " + count);
                }
        );
    }

    public void findHighestFrequencyOfCharacters(String input){
        Map<Character, Long> result =
        input.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(
                ch -> ch, Collectors.counting()
        ));

        Long maxValue = result.values().stream().max((a, b) -> a.compareTo(b)).orElse(null);

        Map<Character, Long> finalResult =
        result.entrySet().stream().filter(ch -> ch.getValue().equals(maxValue)).collect(Collectors.toMap(
                ch -> ch.getKey(), ch -> ch.getValue()
        ));

        System.out.println("Highest Character's Frequency: "+finalResult);
    }


}
