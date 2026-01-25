package streamapi.intermediateoperations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JavaFilters {

    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(1, 25, 3, 7, 3, 1, 16, 13);

        List<String> words = Arrays.asList("Hello", "Arghya", "bHaiyA", "australia", "GErmany");

        filterNosGreaterThanFive(numbers);

        filterEvenNumbers(numbers);

        filterWordsWihUpperCaseIndexOne(words);

        filterWordsStartsWithUpperCase(words);

        filterNosStartsWithOne(numbers);

        filterOutDuplicateNosFromList(numbers);

    }




    private static void filterWordsStartsWithUpperCase(List<String> words) {
        List<String> filteredResult = words.stream()
                .filter(str -> Character.isUpperCase(str.charAt(0)))
                .toList();

        System.out.println("Filtered words starts with uppercase: "+filteredResult);
    }

    private static void filterWordsWihUpperCaseIndexOne(List<String> words) {
        List<String> filteredResult = words.stream()
                .filter(s -> Character.isUpperCase(s.charAt(1)))
                .toList();

        System.out.println("Filtered words with uppercase at index one: "+filteredResult);
    }

    private static void filterEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n%2 == 0)
                .toList();

        System.out.println("Even numbers are: "+evenNumbers);
    }

    private static void filterNosGreaterThanFive(List<Integer> numbers) {
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n > 5)
                .toList();

        System.out.println("Filtered numbers Greater than 5: "+filteredNumbers);
    }

    private static void filterNosStartsWithOne(List<Integer> numbers) {

        List<Integer> filteredNumbers = numbers.stream().filter(
                n -> String.valueOf(n).startsWith("1")
        ).toList();
        System.out.println("Filtered numbers Starts With One: "+filteredNumbers);
    }

    private static void filterOutDuplicateNosFromList(List<Integer> numbers) {

        List<Integer> filteredNumbers = numbers.stream().filter(
                n -> Collections.frequency(numbers, n) > 1
        ).distinct().toList();

        System.out.println("Filtered Duplicate Numbers: "+filteredNumbers);
    }
}
