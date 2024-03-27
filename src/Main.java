public class Main {
    public static void main(String[] args) {
        employees[0] = new Employee("Петров Петр Петрович", 1, 3300);
        employees[1] = new Employee("Антонов Антон Антонович", 2, 5500);
        employees[2] = new Employee("Станиславов Станислав Станиславович", 3, 1100);
        employees[3] = new Employee("Янов Ян Янович", 3, 7700);
        employees[5] = new Employee("Борисов Борис Борисович", 4, 8800);
        employees[7] = new Employee("Залипупов Залипуп Залипупович", 1, 4400);

        System.out.println("Список сотрудников со всеми данными:");
        printAllEmployees();
        System.out.println();

        System.out.println("Сумма затрат на ЗП в месяц: " + countMonthSalaries());
        System.out.println();

        System.out.println("Сотрудник с минимальной ЗП: " + getEmployeeWithMinSalary());
        System.out.println();

        System.out.println("Сотрудник с максимальной ЗП: " + getEmployeeWithMaxSalary());
        System.out.println();

        System.out.printf("Среднее значение ЗП: %.2f\n", averageMonthSalary());
        System.out.println();

        System.out.println("Список ФИО всех сотрудников:");
        printAllEmployeesFullNames();
        System.out.println();
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

    public static Employee getEmployeeWithMaxSalary() {
        Employee empWithMaxSalary = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                empWithMaxSalary = employee;
            }
        }
        if (empWithMaxSalary == null) {
            throw new RuntimeException("Нет ни одного сотрудника");
        }
        return empWithMaxSalary;
    }

    public static double averageMonthSalary() {
        return countMonthSalaries() / (Employee.getEmployeeCounter() - 1);
    }

    public static void printAllEmployeesFullNames() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.getFullName());
            }
        }
    }
}