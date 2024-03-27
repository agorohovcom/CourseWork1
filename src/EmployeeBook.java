public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public boolean addNewEmployee(Employee employee) {
        boolean result = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                result = true;
//                System.out.println("Сотрудник добавлен в ячейку " + i);           // для теста
                break;
            }
        }
        return result;
    }

    public void deleteEmployeeFromId(int id) {
        boolean result = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                result = true;
//                System.out.println("Сотрудник с id " + id + " успешно удалён");   // для теста
                break;
            }
        }
        if (!result) {
            throw new RuntimeException("Нет сотрудника с id " + id);
        }
    }

    public Employee getEmployeeFromId(int id) {
        Employee resultEmployee = null;
        for (Employee e : employees) {
            if (e != null && e.getId() == id) {
                resultEmployee = e;
                break;
            }
        }
        if (resultEmployee == null) {
            throw new RuntimeException("Нет сотрудника с id " + id);
        }
        return resultEmployee;
    }

    public void printAllEmployees() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public double getSumMonthSalaries() {
        double monthSalaries = 0;
        for (Employee e : employees) {
            if (e != null) {
                monthSalaries += e.getSalary();
            }
        }
        return monthSalaries;
    }

    public Employee getEmployeeWithMinSalary() {
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

    public Employee getEmployeeWithMaxSalary() {
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

    public double getAverageMonthSalary() {
        return getSumMonthSalaries() / (Employee.getEmployeeCounter() - 1);
    }

    public void printAllEmployeesFullNames() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.getFullName());
            }
        }
    }

    public void indexSalaries(int indexValue) {
        for (Employee e : employees) {
            if (e != null) {
                e.setSalary(e.getSalary() + e.getSalary() * indexValue / 100);
            }
        }
    }

    public Employee getEmployeeWithMinSalaryFromDepartment(int department) {
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

    public Employee getEmployeeWithMaxSalaryFromDepartment(int department) {
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

    public double getMonthSalaryFromDepartment(int department) {
        double monthSalaryFromDepartment = 0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                monthSalaryFromDepartment += e.getSalary();
            }
        }
        return monthSalaryFromDepartment;
    }

    public double getAverageMonthSalaryFromDepartment(int department) {
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

    public void indexSalariesFromDepartment(int indexValue, int department) {
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                e.setSalary(e.getSalary() + e.getSalary() * indexValue / 100);
            }
        }
    }

    public void printAllEmployeesFromDepartment(int department) {
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                System.out.println("Сотрудник номер " + e.getId()
                        + " {ФИО: " + e.getFullName()
                        + ", зарплата: " + e.getSalary()
                        + '}');
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(int score) {
        for (Employee e : employees) {
            if (e != null && e.getSalary() < score) {
                System.out.println("Сотрудник номер " + e.getId()
                        + " {ФИО: " + e.getFullName()
                        + ", зарплата: " + e.getSalary()
                        + '}');
            }
        }
    }

    public void printEmployeesWithSalaryMoreThan(int score) {
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
