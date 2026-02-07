package streamapi.new_practice.stream_practice;

import streamapi.new_practice.stream_practice.pojo.EmployeeDetail;

import java.util.Arrays;
import java.util.List;

public class StreamPracticeMain {
    public static void main(String[] args){
        StreamPractice streamPractice = new StreamPractice();
        List<String> nameList = Arrays.asList("Arghya", "Rahul", "Anita", "Suman", "Amit");

        List<EmployeeDetail> employees = List.of(
                new EmployeeDetail(1, "Amit", "IT", 35, "Male", "Delhi", 35L),
                new EmployeeDetail(2, "Ravi", "HR",30, "Male", "Delhi", 20L),
                new EmployeeDetail(3, "Neha", "IT", 27, "Female","Kolkata", 25L),
                new EmployeeDetail(4, "Priya", "Finance",28, "Female","UP", 15L),
                new EmployeeDetail(5, "Suresh", "HR", 37, "Male","Bihar", 10L),
                new EmployeeDetail(6, "Animesh", "Civil", 26, "Male","Kolkata", 10L),
                new EmployeeDetail(7, "Bela", "Finance", 26, "Female","Delhi", 15L)
        );


        /*
        * Find list of employees whose name starts with alphabet A
        * */
        streamPractice.findListOfNameStartWithA(nameList);

        /*
        *Group The employees By Department Names
        * */
        streamPractice.groupByDepartmentNames(employees);

        /*
        * Find the total count of employees using stream
        * */
        streamPractice.totalCountEmployee(employees);

        /*
        * Find the max age of employees
        * */
        streamPractice.findMaxAge(employees);

        /*
        * Find all department names
        * */
        streamPractice.findAllDepartments(employees);

        /*
        * Find the count of employee in each department
        * */
        streamPractice.employeeCountOfEachDepartment(employees);

        /*
        * Find the list of employees whose age is less than 30
        * */
        streamPractice.listOfEmployeeAgeUnder30(employees);

        /*
        * Find the list of employees whose age is in between 26 and 31
        * */
        streamPractice.ageBetween26To31(employees);

        /*
        * Find the average age of male and female employee
        * */
        streamPractice.averageAgeOfMaleAndFemale(employees);

        /*
        * Find the department who is having maximum number of employee
        * {Civil=26, Finance=28, HR=37, IT=35}
        * {Civil={Animesh=26}, Finance={Priya=28}, HR={Suresh=37}, IT={Amit=35}}
        * */
        streamPractice.findMaxAgeByEachDepartment(employees);

        /*
        * Find the department who is having maximum number of employee
        * */
        streamPractice.findDepartmentWithMaximumEmployee(employees);

        /*
        * Find the Employee who stays in Delhi and sort them by their names
        * */
        streamPractice.findAndSortEmployeeStaysInDelhi(employees);

        /*
        * Find the average salary in all departments
        * */
        streamPractice.findAverageSalaryInAllDepartment(employees);

        /*
        * Find the highest salary in each department
        * */
        streamPractice.findHighestSalaryInEachDepartment(employees);

        /*
        * Find the list of employee and sort them by their salary
        * */
        streamPractice.listOfEmployeeSortWithSalary(employees);

        /*
        * Find the employee who has second-highest salary
        * */
        streamPractice.find2ndHighestSalariedEmployee(employees);
    }
}
