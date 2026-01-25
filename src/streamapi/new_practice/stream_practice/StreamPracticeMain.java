package streamapi.new_practice.stream_practice;

import streamapi.new_practice.stream_practice.pojo.EmployeeDetail;

import java.util.Arrays;
import java.util.List;

public class StreamPracticeMain {
    public static void main(String[] args){
        StreamPractice streamPractice = new StreamPractice();
        List<String> nameList = Arrays.asList("Arghya", "Rahul", "Anita", "Suman", "Amit");

        List<EmployeeDetail> employees = List.of(
                new EmployeeDetail(1, "Amit", "IT"),
                new EmployeeDetail(2, "Ravi", "HR"),
                new EmployeeDetail(3, "Neha", "IT"),
                new EmployeeDetail(4, "Priya", "Finance"),
                new EmployeeDetail(5, "Suresh", "HR")
        );


        /*
        * Find list of employees whose name starts with alphabet A
        * */
        streamPractice.findListOfNameStartWithA(nameList);

        /*
        *Group The employees By Department Names
        * */
        streamPractice.groupByDepartmentNames(employees);
    }
}
