package streamapi.new_practice.stream_practice;

import streamapi.new_practice.stream_practice.pojo.EmployeeDetail;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
}
