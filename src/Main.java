public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Петров Петр Петрович", 1, 3300);
        employees[1] = new Employee("Антонов Антон Антонович", 2, 5500);
        employees[2] = new Employee("Станиславов Станислав Станиславович", 3, 1100);
        employees[3] = new Employee("Янов Ян Янович", 4, 7700);

        printAllEmployees(employees);
    }

    public Employee[] employees = new Employee[10];

    public static void printAllEmployees(Employee[] employees) {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }
}