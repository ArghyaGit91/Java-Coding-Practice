package streamapi.new_practice.stream_practice;

import java.util.*;
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

    public void removeAndRemoveDuplicateChars(String input){

        String reversedString = new StringBuilder(input).reverse().toString();

        Set<Character> setUniqueChars = new LinkedHashSet<>();
        char[] charArr = reversedString.toCharArray();
        for (char ch : charArr){
            setUniqueChars.add(ch);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : setUniqueChars){
            stringBuilder.append(ch);
        }

        System.out.println("Input String: "+input);
        System.out.println("After removing duplicate Character updated String: "+stringBuilder);

    }


    public void removeDuplicateAndPreserveOrder(List<String> names) {
        List<String> result = new ArrayList<>(
                new LinkedHashSet<>(names)
        );

        System.out.println("Remove duplicate Strings and Preserve Order Without Stream: "+result);
    }
}
