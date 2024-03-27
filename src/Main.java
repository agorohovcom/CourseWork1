public class Main {
    public static void main(String[] args) {
        employees[0] = new Employee("Петров Петр Петрович", 1, 3300);
        employees[1] = new Employee("Антонов Антон Антонович", 2, 5500);
        employees[2] = new Employee("Станиславов Станислав Станиславович", 3, 1100);
        employees[3] = new Employee("Янов Ян Янович", 3, 7700);
        employees[5] = new Employee("Борисов Борис Борисович", 4, 8800);
        employees[7] = new Employee("Залипупов Залипуп Залипупович", 1, 4400);
        employees[8] = new Employee("Геннадьев Геннадий Геннадиевич", 5, 10000);

        System.out.println("Список сотрудников со всеми данными:");
        printAllEmployees();
        System.out.println();

        System.out.println("Сумма затрат на ЗП в месяц: " + getSumMonthSalaries());
        System.out.println();

        System.out.println("Сотрудник с минимальной ЗП: " + getEmployeeWithMinSalary());
        System.out.println();

        System.out.println("Сотрудник с максимальной ЗП: " + getEmployeeWithMaxSalary());
        System.out.println();

        System.out.printf("Среднее значение ЗП: %.2f\n", getAverageMonthSalary());
        System.out.println();

        System.out.println("Список ФИО всех сотрудников:");
        printAllEmployeesFullNames();
        System.out.println();

        int indexValue = 10;
        System.out.printf("Индексируем ЗП сотрудников на %d процентов\n", indexValue);
        indexSalaries(indexValue);
        System.out.println("Список всех сотрудников:");
        printAllEmployees();
        System.out.println();

        int department = 3;
        System.out.printf("Сотрудник с минимальной ЗП в отделе %d:\n", department);
        System.out.println(getEmployeeWithMinSalaryFromDepartment(department));
        System.out.println();

        System.out.printf("Сотрудник с максимальной ЗП в отделе %d:\n", department);
        System.out.println(getEmployeeWithMaxSalaryFromDepartment(department));
        System.out.println();

        System.out.printf("Сумма затрат на ЗП по отделу %d: %.2f\n", department, getMonthSalaryFromDepartment(department));
        System.out.println();

        System.out.printf("Средняя ЗП по отделу %d составляет %.2f\n", department, getAverageMonthSalaryFromDepartment(department));
        System.out.println();

        System.out.printf("Индексируем ЗП сотрудников из отдела %d на %d процентов\n", department, indexValue);
        indexSalariesFromDepartment(indexValue, department);
        System.out.println("Список всех сотрудников:");
        printAllEmployees();
        System.out.println();

        System.out.printf("Список сотрудников из отдела %d\n", department);
        printAllEmployeesFromDepartment(department);
        System.out.println();

        int score = 5000;
        System.out.printf("Список сотрудников с ЗП до %d:\n", score);
        printEmployeesWithSalaryLessThan(score);
        System.out.println();

        System.out.printf("Список сотрудников с ЗП от %d и выше:\n", score);
        printEmployeesWithSalaryMoreThan(score);
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

    public static double getSumMonthSalaries() {
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

    public static double getAverageMonthSalary() {
        return getSumMonthSalaries() / (Employee.getEmployeeCounter() - 1);
    }

    public static void printAllEmployeesFullNames() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.getFullName());
            }
        }
    }

    public static void indexSalaries(int indexValue) {
        for (Employee e : employees) {
            if (e != null) {
                e.setSalary(e.getSalary() + e.getSalary() * indexValue / 100);
            }
        }
    }

    public static Employee getEmployeeWithMinSalaryFromDepartment(int department) {
        Employee employeeToReturn = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeToReturn = employee;
            }
        }
        if (employeeToReturn == null) {
            throw new RuntimeException("В отделе номер " + department + " нет сотрудников");
        }
        return employeeToReturn;
    }

    public static Employee getEmployeeWithMaxSalaryFromDepartment(int department) {
        Employee employeeToReturn = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeToReturn = employee;
            }
        }
        if (employeeToReturn == null) {
            throw new RuntimeException("В отделе номер " + department + " нет сотрудников");
        }
        return employeeToReturn;
    }

    public static double getMonthSalaryFromDepartment(int department) {
        double monthSalaryFromDepartment = 0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                monthSalaryFromDepartment += e.getSalary();
            }
        }
        return monthSalaryFromDepartment;
    }

    public static double getAverageMonthSalaryFromDepartment(int department) {
        int countEmployeesFromDepartment = 0;
        double sumSalariesFromDepartment = 0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                countEmployeesFromDepartment++;
                sumSalariesFromDepartment += e.getSalary();
            }
        }
        return sumSalariesFromDepartment / countEmployeesFromDepartment;
    }

    public static void indexSalariesFromDepartment(int indexValue, int department) {
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                e.setSalary(e.getSalary() + e.getSalary() * indexValue / 100);
            }
        }
    }

    public static void printAllEmployeesFromDepartment(int department) {
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                System.out.println("Сотрудник номер " + e.getId()
                        + " {ФИО: " + e.getFullName()
                        + ", зарплата: " + e.getSalary()
                        + '}');
            }
        }
    }

    public static void printEmployeesWithSalaryLessThan(int score) {
        for (Employee e : employees) {
            if (e != null && e.getSalary() < score) {
                System.out.println("Сотрудник номер " + e.getId()
                        + " {ФИО: " + e.getFullName()
                        + ", зарплата: " + e.getSalary()
                        + '}');
            }
        }
    }

    public static void printEmployeesWithSalaryMoreThan(int score) {
        for (Employee e : employees) {
            if (e != null && e.getSalary() >= score) {
                System.out.println("Сотрудник номер " + e.getId()
                        + " {ФИО: " + e.getFullName()
                        + ", зарплата: " + e.getSalary()
                        + '}');
            }
        }
    }
}