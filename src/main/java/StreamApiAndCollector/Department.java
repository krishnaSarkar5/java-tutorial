package StreamApiAndCollector;

public class Department {

    private Long id;

    private String departmentName;

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }


    @Override
    public String toString() {
        return "{ id: "+id+", " +
                "departmentName: "+departmentName+" }";
    }
}
