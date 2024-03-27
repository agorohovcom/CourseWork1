import java.util.Objects;

public class Employee {
    private final String fullName;
    private int department;
    private double salary;
    private final int id;

    private static short employeeCounter = 1;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = employeeCounter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getEmployeeCounter() {
        return employeeCounter;
    }

    public void setDepartment(short department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    @Override
    public String toString() {
        return "Сотрудник номер " + id
                + " {ФИО: " + fullName
                + ", отдел: " + department
                + ", зарплата: " + salary
                + '}';
    }
}
