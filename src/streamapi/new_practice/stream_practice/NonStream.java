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

    public void findNonRepeatingCharacters(String input) {
        Stream<Character> streamOfCharacters = input.chars().mapToObj(c -> (char) c);

        Map<Character, Long> mapOfChars =
                streamOfCharacters.collect(
                        Collectors.groupingBy(
                                ch -> ch,
                                () -> new LinkedHashMap<Character, Long>(),
                                Collectors.counting()
                        )
                );

        System.out.println("Non repeating characters: Map(All)"+mapOfChars);

        List<Character> resultNonRepeatingCharacters =
                mapOfChars.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey()).toList();

        System.out.println("Non repeating characters: final output: "+resultNonRepeatingCharacters);

    }
}
