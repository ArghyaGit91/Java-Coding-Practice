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


}
