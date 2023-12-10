import java.math.BigDecimal;

public class Developer {
    private String name ;
    private String specialty;
    private BigDecimal salary;

    public Developer(String name, String specialty, double salary) {
        this.name = name;
        this.specialty = specialty;
        this.salary = BigDecimal.valueOf(salary);
    }
    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
