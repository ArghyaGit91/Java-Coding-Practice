package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<String> colors = List.of("RED", "grEEn", "white", "Orange", "pink");

//        Calculate average of list of nos

        Stream<Integer> numberStream = numbers.stream();

        int sum = 0;
        double average = numberStream.mapToDouble(i -> sum + i).average().orElse(0.0);
        System.out.println("average is: "+ average);


//        sum of each nos from list

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        int sum2 = numbers2.stream()
                .reduce(0, (a,b) -> a+b);
        int temp = 0;
        
//        int sum2 = numbers2.stream().mapToInt(i -> temp + i).sum();

        for (Integer item: numbers2){
            temp = temp + item;
        }



        System.out.println("Sum of all numbers: " + sum2);
        System.out.println("Sum of all numbers: " + temp);

//        Convert list of strings to uppercase and lowercase

        Stream<String> colorsStream = colors.stream();
        List<String> uppercaseStrings = colorsStream.map(i -> i.toUpperCase()).collect(Collectors.toList());
        List<String> lowerCaseStrings = colors.stream().map(String::toLowerCase).toList();
        System.out.println("UpperCase: "+uppercaseStrings);
        System.out.println("LowerCase: "+lowerCaseStrings);

//        calculate the sum of all even, odd numbers in a list

        List <Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> evenSumStream = numbers3.stream();

        int sumEvenResult = evenSumStream.filter(item -> item % 2 == 0).reduce(0, Integer::sum);
        System.out.println("Even sum result: "+sumEvenResult);

        Stream<Integer> oddSumStream = numbers3.stream();

        int sumOdd = oddSumStream.filter(item -> item % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("Odd sum result: "+sumOdd);

//        remove all duplicate elements from a list

        List < Integer > numbers4 = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);

        List<Integer> listWithDuplicateNos = numbers4.stream().toList();
        System.out.println("List with duplicate nos: "+listWithDuplicateNos);

        List<Integer> listWithoutDuplicateNos = numbers4.stream().distinct().toList();
        System.out.println("List without duplicate nos: "+listWithoutDuplicateNos);

//        count the number of strings in a list that start with a specific letter

        List < String > colors2 = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        System.out.println("Original list of strings (colors): " + colors);

        char startingLetter = 'B';

        long count = colors2.stream().filter(item -> item.startsWith(String.valueOf(startingLetter))).count();

        System.out.println("\nNumber of colors starting with '" + startingLetter + "': " + count);

//        sort a list of strings in alphabetical order, ascending and descending

        List<String> sortedAscList = colors2.stream().sorted().toList();
        System.out.println("Unsorted list: "+colors2);
        System.out.println("Sorted list ascending order: "+sortedAscList);

        List<String> sortedDescList = colors2.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted list descending order: "+sortedDescList);

//        find the maximum and minimum values in a list of integers

        List < Integer > numbers5 = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);

        System.out.println("List of number is: "+numbers5);

        int min = numbers5.stream().min(Comparator.comparing(item -> item)).orElse(null);
        System.out.println("Minimum number is: "+min);

        int max = numbers5.stream().max(Comparator.comparing(Integer::valueOf)).orElse(null);
        System.out.println("Maximum number is: "+max);

//        find the second smallest and largest elements in a list of integers using streams.

        int secondLowest = numbers5.stream().sorted().skip(1).min(Comparator.comparing(item -> item)).orElse(null);
        int secondLargest = numbers5.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println("2nd Lowest number is: "+secondLowest);
        System.out.println("2nd Largest number is: "+secondLargest);

//        Filter the name starts with j and convert it to uppercase
        List<String> namesList = List.of("arghya","arka","jordon","Ganesh","jogesh");
        char startedChar ='j';
        List<String> convertedList = namesList.stream().filter(item -> item.startsWith(String.valueOf(startedChar)))
                .map(String::toUpperCase).toList();
        System.out.println("Converted List is: "+convertedList);


        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        List<Integer> evemNosList = list.stream()
                .filter(n -> n%2 == 0).toList();
//                .forEach(System.out::println);

        for (int item: evemNosList){
            System.out.println("list is: "+item);
        }

    }
}
