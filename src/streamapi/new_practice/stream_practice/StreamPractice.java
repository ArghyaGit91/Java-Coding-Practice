package streamapi.new_practice.stream_practice;

import streamapi.new_practice.Employee;
import streamapi.new_practice.stream_practice.pojo.EmployeeDetail;

import java.util.*;
import java.util.stream.Collectors;

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
}
