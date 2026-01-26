package streamapi.new_practice.stream_practice;

import streamapi.new_practice.stream_practice.pojo.EmployeeDetail;

import java.util.Arrays;
import java.util.List;

public class StreamPracticeMain {
    public static void main(String[] args){
        StreamPractice streamPractice = new StreamPractice();
        List<String> nameList = Arrays.asList("Arghya", "Rahul", "Anita", "Suman", "Amit");

        List<EmployeeDetail> employees = List.of(
                new EmployeeDetail(1, "Amit", "IT", 35),
                new EmployeeDetail(2, "Ravi", "HR",30),
                new EmployeeDetail(3, "Neha", "IT", 27),
                new EmployeeDetail(4, "Priya", "Finance",28),
                new EmployeeDetail(5, "Suresh", "HR", 37)
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
    }
}
