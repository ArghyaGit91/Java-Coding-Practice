package streamapi.new_practice.stream_practice;

import streamapi.new_practice.stream_practice.pojo.EmployeeDetail;

import java.util.List;
import java.util.Map;
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
}
