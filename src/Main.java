public class Main {
    public static void main(String[] args) {
        employees[0] = new Employee("Петров Петр Петрович", 1, 3300);
        employees[1] = new Employee("Антонов Антон Антонович", 2, 5500);
        employees[2] = new Employee("Станиславов Станислав Станиславович", 3, 1100);
        employees[3] = new Employee("Янов Ян Янович", 4, 7700);

        printAllEmployees();
        System.out.println("Сумма затрат на ЗП в месяц: " + countMonthSalaries());
        System.out.println("Сотрудник с минимальной ЗП: " + getEmployeeWithMinSalary());
    }

    public static Employee[] employees = new Employee[10];

    public static void printAllEmployees() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public static double countMonthSalaries() {
        double monthSalaries = 0;
        for (Employee e : employees) {
            if (e != null) {
                monthSalaries += e.getSalary();
            }
        }
        return monthSalaries;
    }

    public static Employee getEmployeeWithMinSalary() {
        Employee empWithMinSalary = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                empWithMinSalary = employee;
            }
        }
        if (empWithMinSalary == null) {
            throw new RuntimeException("Нет ни одного сотрудника");
        }
        return empWithMinSalary;
    }
}