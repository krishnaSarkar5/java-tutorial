package StreamApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

    private Long id;

    private String  name;

    private LocalDate joiningDate;

    private Integer salary;

    private Department department;


    public Employee() {
    }

    public Employee(Long id, String name, LocalDate joiningDate, Integer salary, Department department) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "{ id: "+id+"," +
                " name: "+name+", " +
                "joiningDate: "+joiningDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+", " +
                "salary: "+salary+", " +
                "department: "+department+" }";
    }
}
