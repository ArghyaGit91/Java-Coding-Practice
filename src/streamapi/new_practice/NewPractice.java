package streamapi.new_practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class NewPractice {


    public List<Integer> filteredEvenNumbersThenSquare(List<Integer> integerList){

        /*
        * Write a program to filter only even numbers, square them, and collect the results
        * into a new list.
        * */

        List<Integer> filteredEvenNumbers = integerList.stream()
                .filter(n -> n%2 == 0)
                .peek(n -> System.out.println("Even numbers: "+n))
                .map(n -> n * n)
                .toList();

        return filteredEvenNumbers;
    }

    public Optional<String> upperCaseNameAndSortAlphabetically(List<String> listOfNames){

        /*
         * Write a program to convert all names to uppercase, sort them alphabetically,
         * and find the first name starting with "A".
         * */

        Optional<String> findFirstName = listOfNames.stream()
                .map(n -> n.toUpperCase())
                .sorted()
                .peek(n -> System.out.println("UpperCase and Sort: "+n))
                .filter(n -> n.startsWith("A"))
                .findFirst();

        return findFirstName;
    }

    public Long salaryGreaterThan50K(List<Employee> employeeList) {

        /*
         * You have a list of employees with id, name, salary. Write a program to filter employees earning more than 50,000,
         * extract their names, and count how many meet the condition.
         * */

        Long count = employeeList.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .peek(emp -> System.out.println("Employee: "+emp.getName()))
                .count();

        return count;
    }

    public List<Employee> employeeSortWithSalary(List<Employee> employeeList) {
        List<Employee> employeeSortWithSalary = employeeList.stream().sorted((p1,p2) -> Math.toIntExact(p2.getSalary() - p1.getSalary())).collect(Collectors.toList());
//        List<Employee> employeeSortWithSalary = employeeList.stream().reduce((p1,p2) -> p1.getSalary() >= p2.getSalary()).stream().sorted().collect(Collectors.toList());
        return employeeSortWithSalary;
    }

    public Long itemFrequencyCount(List<String> fruitsList) {
        Map<Object, Long> itemFrequency =  fruitsList.parallelStream()
                .collect(Collectors.groupingBy(item -> item,counting()));

        System.out.println("ItemFrequency: "+itemFrequency);

        Map.Entry<Object, Long> mostFrequency = itemFrequency.entrySet().stream().max(Map.Entry.comparingByValue())
                .orElse(null);

        if (mostFrequency != null) {
            System.out.println("Most frequent word: "
                    + mostFrequency.getKey() + " (count = " + mostFrequency.getValue() + ")");
        }

        return Objects.requireNonNull(mostFrequency).getValue();
    }

    public int sumAndSummary(List<Integer> integerList) {
        int sum = integerList.stream().reduce(0,(a,b) -> a+b);
        return sum;
    }

    public IntSummaryStatistics summaryStatistics(List<Integer> integerList){
        return integerList.stream().mapToInt(n -> n.intValue()).summaryStatistics();
    }

    public Integer find2ndHighestNumber(List<Integer> integerList){
        /*
         * Find the second-highest number in a list
         * */
        int secondHighestNumber = 0;
        Optional<Integer> filteredNumber = integerList.stream().distinct().sorted(Comparator.reverseOrder())
                .skip(1).findFirst();
        secondHighestNumber = filteredNumber.get();
        return secondHighestNumber;
    }

    public List<Integer> flatList(List<List<Integer>> listOfListInteger) {
        List<Integer> flatList = listOfListInteger.stream().flatMap(list -> list.stream()).distinct()
//                .sorted((a, b) -> b.compareTo(a)) // descending order
                .sorted() // ascending order
                .toList();
        return flatList;
    }

    public Product findProductWithHighestPrice(List<Product> productList) {

        Optional<Product> productOptional = productList.stream().map(
                product -> {
                    product.setPrice(
                            Math.subtractExact(
                                    product.getPrice(),
                                    Math.divideExact(Math.multiplyExact(product.getPrice(), 10), 100)
                    ));
                    return product;
                }
        ).peek(product -> System.out.println("ProductName: "+product.getName() +" Price: "+product.getPrice()))
                .max(Comparator.comparing(product -> product.getPrice()));

        if (productOptional.isPresent()){
            return (productOptional.get());

        }else {
            return null;
        }
    }

    public Long calculateDiscounedTotalPrice(List<Product> productList) {

        Long allProductPrice = productList.parallelStream().map(product -> {
            product.setPrice(
                    calculateDiscountedPrice(product.getPrice())
            );
            return product;
        }).map(product -> product.getPrice()).reduce(0L ,(a,b) -> a+b);

        return allProductPrice;

    }

    public Long calculateDiscountedPrice(Long price){
        Long discount = price * 10 / 100;
        Long finalPrice = price - discount;

        return finalPrice;
    }
}
