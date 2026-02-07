package streamapi.new_practice.stream_practice.pojo;

public class EmployeeDetail {
    private int id;
    private String name;
    private String department;
    private String gender;
    private String address;
    private int age;
    private Long salary;

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public EmployeeDetail(int id, String name, String department, int age, String gender, String address, Long salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" +age + '\''+
                ", gender=" +gender +'\''+
                ", address=" +address +'\''+
                ", salary=" +salary +'\''+
                '}';
    }
}
