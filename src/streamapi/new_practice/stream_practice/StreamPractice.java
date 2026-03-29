package streamapi.new_practice.stream_practice;

import streamapi.new_practice.stream_practice.pojo.EmployeeDetail;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamPractice {
    public void findListOfNameStartWithA(List<String> nameList) {
        List<String> filteredNameList = nameList.stream().filter(name -> name.startsWith("A")).toList();
        for (String name : filteredNameList){
            System.out.println("NamesStartWithA: "+ name);
        }
    }

    public void groupByDepartmentNames(List<EmployeeDetail> employees) {

        Map<String, List<EmployeeDetail>> result =
        employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment()));

        System.out.println("GroupByDepartment: "+result);
    }

    public void totalCountEmployee(List<EmployeeDetail> employees) {
        long totalCountEmployee = employees.stream().count();
        System.out.println("TotalCountEmployee: "+totalCountEmployee);
    }

    public void findMaxAge(List<EmployeeDetail> employees) {

        Optional<EmployeeDetail> employee = employees.stream().max(Comparator.comparing(employeeDetail -> employeeDetail.getAge()));

        if (employee.isPresent()){
            System.out.println("Maximum age of an employee: "+employee.get().getName()+" Age: "+employee.get().getAge());
        }

    }

    public void findAllDepartments(List<EmployeeDetail> employees) {
        List<String> allDepartments = employees.stream().map(employeeDetail -> employeeDetail.getDepartment()).distinct().toList();
        System.out.println("All Departments: "+allDepartments);
    }

    public void employeeCountOfEachDepartment(List<EmployeeDetail> employees){
        Map<String, Long> result = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.counting()));
        System.out.println("Employee Count of Each Department: "+ result);
    }

    public void listOfEmployeeAgeUnder30(List<EmployeeDetail> employees){

        List<EmployeeDetail> employeeList = employees.stream().filter(emp -> emp.getAge() < 30).toList();
        List<String> employeeNames = employees.stream().filter(emp -> emp.getAge() < 30).map(emp -> emp.getName()).toList();
        System.out.println("List of Employee Age Under 30: "+ employeeList);
        System.out.println("List of Employee Name Age Under 30: "+ employeeNames);

    }

    public void ageBetween26To31(List<EmployeeDetail> employees) {

        List<EmployeeDetail> employeeList = employees.stream().filter(emp -> emp.getAge() > 26 && emp.getAge() < 31).toList();
        System.out.println("List of Employee Age between 26 & 31: "+ employeeList);
    }

    public void averageAgeOfMaleAndFemale(List<EmployeeDetail> employees) {

        Map<String, Double> result = employees.stream().collect(Collectors.groupingBy(
                employeeDetail -> employeeDetail.getGender(), Collectors.averagingInt(emp -> emp.getAge())
        ));
        System.out.println("Average Age of Male & Female: "+ result);

    }

    public void findMaxAgeByEachDepartment(List<EmployeeDetail> employeeDetails){

        Map<String, Integer> result = employeeDetails.stream().collect(Collectors.groupingBy(
                emp -> emp.getDepartment(), Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(
                        e -> e.getAge())), optEmp -> optEmp.isPresent() ? optEmp.get().getAge() : 0
        )));



        System.out.println("MaxAgeOfEachDepartment: "+ result);

        Map<String, Map<String, Integer>> result2 =
                employeeDetails.stream().collect(Collectors.groupingBy(
                        employeeDetail -> employeeDetail.getDepartment(), Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(
                                        e -> e.getAge()
                                )), optEmp -> optEmp.map(
                                        employeeDetail -> Map.of(employeeDetail.getName(), employeeDetail.getAge())
                                ).orElse(Collections.emptyMap())
                        )
                ));

        System.out.println("Maximum Age Of EachDepartment With Employee Name: "+ result2);

    }

    public void findDepartmentWithMaximumEmployee(List<EmployeeDetail> employees) {
        Map<String, Long> result = employees.stream().collect(Collectors.groupingBy(emp ->
                emp.getDepartment(), Collectors.counting()
        ));
        System.out.println("Find Department With Maximum Employee: "+ result);
//                .entrySet().stream().max(Map.Entry.comparingByValue()).map(optEmp -> Map.of(optEmp.getKey(), optEmp.getValue()))
//                .orElse(Collections.emptyMap());
        Map<String, Long> finalResult = result.entrySet().stream().max(Map.Entry.comparingByValue()).map(e-> Map.of(e.getKey(), e.getValue())).orElse(Collections.emptyMap());

        System.out.println("Find Final Result Department With Maximum Employee: "+ finalResult);
    }

    public void findAndSortEmployeeStaysInDelhi(List<EmployeeDetail> employees) {
        List<String> employeeList = employees.stream().filter(emp ->
                emp.getAddress().equalsIgnoreCase("Delhi")).map(e -> e.getName()).sorted().toList();

        System.out.println("Find and sort the employees who are staying in Delhi: "+ employeeList);
    }

    public void findAverageSalaryInAllDepartment(List<EmployeeDetail> employees) {

        Map<String, Double> result = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment(),
                Collectors.averagingLong(e -> e.getSalary())));

        System.out.println("Find average salary from each department : "+ result);
    }

    public void findHighestSalaryInEachDepartment(List<EmployeeDetail> employees) {

        Map<String, Map<String, Long>> result =
        employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparing(e -> e.getSalary())), optEmp -> optEmp.map(
                        employee -> Map.of(employee.getName(), employee.getSalary())
                ).orElse(Collections.emptyMap())
        )));

        System.out.println("Find highest salary in each department: "+result);

    }

    public void listOfEmployeeSortWithSalary(List<EmployeeDetail> employees) {

        List<EmployeeDetail> employeeList = employees.stream().sorted(Comparator.comparing((EmployeeDetail emp) -> emp.getSalary()).reversed()).toList();
        System.out.println("List of Employee sort with Salary: "+employeeList);
    }

    public void find2ndHighestSalariedEmployee(List<EmployeeDetail> employees) {

        Map<String, Long> employeeDetail = employees.stream().sorted(Comparator.comparing((EmployeeDetail emp) ->
                emp.getSalary()).reversed()).skip(1).findFirst().map(e -> Map.of(e.getName(), e.getSalary())).orElse(null);

        System.out.println("Find the employee who has 2nd highest salary: "+employeeDetail);

//        Map<String, Long> result = employeeDetail.stream().map(e -> Map.of(e.getName(), e.getSalary()));
    }


    public void countWords(List<String> words){

	    Map<String, Long> result = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    System.out.println("Count words frequency: "+result);
    }

    public void countOccurrenceOfDuplicateStrings(List<String> words){

        Map<String, Long> result = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> duplicateResult = result.entrySet().stream().filter(word -> word.getValue() > 1)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                        (a, b) -> a,
                        () -> new HashMap<>()));

        System.out.println("Count duplicate words frequency: "+duplicateResult);
    }

    public void findNonRepeatingWords(List<String> words){

        Map<String, Long> result = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> nonRepeatingWords = result.entrySet().stream().filter(word -> word.getValue() == 1).map(e->e.getKey()).toList();


        System.out.println("Find non-repeating words: "+nonRepeatingWords);
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

        System.out.println("Non repeating characters: Map(All): "+mapOfChars);

        List<Character> resultNonRepeatingCharacters =
                mapOfChars.entrySet().stream().filter(entry -> entry.getValue() == 1)
                        .map(entry -> entry.getKey()).toList();

        System.out.println("Non repeating characters: final output: "+resultNonRepeatingCharacters);

    }
    public void findFirstNonRepeatingCharacter(String input) {
        Stream<Character> streamOfCharacters = input.chars().mapToObj(c -> (char) c);

        Map<Character, Long> mapOfChars =
                streamOfCharacters.collect(
                        Collectors.groupingBy(
                                ch -> ch,
                                () -> new LinkedHashMap<Character, Long>(),
                                Collectors.counting()
                        )
                );

        System.out.println("Non repeating characters: Map(All): "+mapOfChars);

        Character result =
                mapOfChars.entrySet().stream().filter(entry -> entry.getValue() == 1)
                        .map(entry -> entry.getKey()).findFirst().orElse(null);

        System.out.println("First Non repeating character: final output: "+result);

    }

    public void findLongestStringFromList(List<String> words){
        String longestString =
                words.stream().max(Comparator.comparingInt(
                        item -> item.length()
                )).orElse(null);

        System.out.println("Find Longest String: "+longestString);
    }

    public void groupByStringLength(List<String> words){
        Map<Integer, List<String>> finalResult =
                words.stream().collect(Collectors.groupingBy(item -> item.length()));

        System.out.println("Grouping by Length: "+finalResult);
    }

    public void countEachChracterFrequency(List<String> words){
        Map<Character, Long> finalResult =
                words.stream().flatMap(
                        entry -> entry.chars().mapToObj(
                                character ->(char) character))
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ));

        System.out.println("Count Character Frequency Across All Strings: "+finalResult);
    }

    public void stringStartWithVowel(List<String> words){
        List<String> result = words.stream().filter(entry -> entry.matches("^[aeiou].*")).toList();
        System.out.println("Find Strings Starting With Vowel: "+result);

        List<String> result2 = words.stream()
                .filter(word -> "aeiou".contains(
                        word.substring(0,1).toLowerCase()))
                .toList();
    }

    public void findHighestFrequencyWords(List<String> words) {


        Map<String, Long> freqMap = words.stream().collect(Collectors.groupingBy(
                w -> w,  Collectors.counting())
        );

        Long maxFreq = freqMap.values().stream() .max((a, b) -> a.compareTo(b)) .orElse(0L);

        Map<String, Long> highestFreqWords = freqMap.entrySet().stream().filter(entry -> entry.getValue().equals(maxFreq))
                .collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));

        System.out.println("Highest Frequency Words: "+highestFreqWords);

    }

    public void filterEmployee(List<EmployeeDetail> employees) {

        List<EmployeeDetail> employeeDetailList =
                employees.stream().sorted(Comparator.comparing((EmployeeDetail emp) -> emp.getName()).thenComparing(
                        emp -> emp.getAge()).thenComparing(emp -> emp.getSalary())
                ).toList();

        employeeDetailList.forEach(emp -> System.out.println(emp.getName()));
//        System.out.println("Sorted Employee Details: "+employeeDetailList);

        Map<String, List<EmployeeDetail>> employeeDetailMap = employeeDetailList.stream().collect(
                Collectors.groupingBy(emp -> emp.getName())
        );

        System.out.println("Sorted & Mapped Employee Details: "+employeeDetailMap);


    }

    public void listOfEmployeesStartsWithA(List<EmployeeDetail> employeeDetailList){

        List<String> employeeList = employeeDetailList.stream().filter(emp -> emp.getName().startsWith("A"))
                .map(emp -> emp.getName()).toList();

    }
}


