package streamapi.new_practice;

public class Employee {
    private int id;
    private String name;
    private Long salary;

    public Employee(int id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id +
                "', name=" + name +
                ", salary=" + salary + "}";
    }
}
