package streamapi.new_practice.stream_practice;

import streamapi.new_practice.stream_practice.pojo.EmployeeDetail;

import java.util.Arrays;
import java.util.List;

public class StreamPracticeMain {
    public static void main(String[] args){
        StreamPractice streamPractice = new StreamPractice();
        List<String> nameList = Arrays.asList("Arghya", "Rahul", "Anita", "Suman", "Amit");

        List<EmployeeDetail> employees = List.of(
                new EmployeeDetail(1, "Amit", "IT", 35, "Male"),
                new EmployeeDetail(2, "Ravi", "HR",30, "Male"),
                new EmployeeDetail(3, "Neha", "IT", 27, "Female"),
                new EmployeeDetail(4, "Priya", "Finance",28, "Female"),
                new EmployeeDetail(5, "Suresh", "HR", 37, "Male"),
                new EmployeeDetail(6, "Animesh", "Civil", 26, "Male")
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
    }
}
