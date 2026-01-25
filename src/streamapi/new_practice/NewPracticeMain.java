package streamapi.new_practice;

import java.util.*;

public class NewPracticeMain {


    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1, 23, 4, 78, 5, 13);
        List<Integer> newIntegerList = Arrays.asList(1, 23, 4, 78, 5, 13, 23);
        List<List<Integer>> listOfListInteger = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5),
                Arrays.asList(8,13, 10, 6, 5, 10, 4)

        );
        List<String> nameList = Arrays.asList("Arghya", "Rahul", "Anita", "Suman", "Amit");
        List<String> fruitsList = Arrays.asList("apple","banana","apple","orange","banana","apple");

        String str = "Java";
        String strConcat = str.concat(" World");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Arghya", 49000L));
        employeeList.add(new Employee(2, "Rahul", 52000L));
        employeeList.add(new Employee(3, "Anita", 60000L));
        employeeList.add(new Employee(4, "Suman", 30000L));
        employeeList.add(new Employee(5, "Amit", 20000L));

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "iPhone", 69000L));
        productList.add(new Product(2, "HP Laptop", 52000L));
        productList.add(new Product(3, "Moto Phone", 20000L));
        productList.add(new Product(4, "Dell Laptop", 60000L));
        productList.add(new Product(5, "Macbook", 200000L));


        NewPractice newPractice = new NewPractice();
        /*
         * Write a program to filter only even numbers, square them, and collect the results
         * into a new list.
         * */
        List<Integer> filteredEvenNumbers = newPractice.filteredEvenNumbersThenSquare(integerList);
        System.out.println("Even numbers with Square: "+filteredEvenNumbers);

        /*
        * Write a program to convert all names to uppercase, sort them alphabetically,
        * and find the first name starting with "A".
        * */
        Optional<String> modifiedNames = newPractice.upperCaseNameAndSortAlphabetically(nameList);
        System.out.println("Uppercase, sort: "+modifiedNames);

        /*
        * You have a list of employees with id, name, salary. Write a program to filter employees earning more than 50,000,
        * extract their names, and count how many meet the condition.
        * */
        Long count = newPractice.salaryGreaterThan50K(employeeList);
        System.out.println("Count: "+count);

        List<Employee> employeeSortWithSalary = newPractice.employeeSortWithSalary(employeeList);
        employeeSortWithSalary.forEach(System.out::println);
//        System.out.println("Sort With Salary: "+employeeSortWithSalary);


        /*
        * Write a program to count occurrences of each word and find the most frequent one.
        * */
        Long itemFrequency = newPractice.itemFrequencyCount(fruitsList);
        System.out.println("Count Item frequency: "+itemFrequency);

        /*
        * Number Statistics Goal: Practice reduce, summaryStatistics.
        * */
        int sum = newPractice.sumAndSummary(integerList);
        System.out.println("Sum is: "+sum);

        IntSummaryStatistics stat = newPractice.summaryStatistics(integerList);
        System.out.println("Summary is: "+stat);

        /*
        * Find the second-highest number in a list
        * */
        int secondHighestNumber = newPractice.find2ndHighestNumber(newIntegerList);
        System.out.println("SecondHighestNumber: "+secondHighestNumber);

        /*
        * Flatten a list of lists using
        * */
        List<Integer> flatList = newPractice.flatList(listOfListInteger);
        System.out.println("FlatList: "+flatList);

        Product product = newPractice.findProductWithHighestPrice(productList);
        System.out.println("Highest Priced Product Name: "+product.getName() +" Price: "+product.getPrice());

        Long allProductPrice = newPractice.calculateDiscounedTotalPrice(productList);
        System.out.println("Sum of Discounted price: "+allProductPrice);

    }
}
