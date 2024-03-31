public class Main {
    public static void main(String[] args) {
        EmployeeBook empBook = new EmployeeBook();
        empBook.addNewEmployee(new Employee("Петров Петр Петрович", 1, 3300));
        empBook.addNewEmployee(new Employee("Антонов Антон Антонович", 2, 5500));
        empBook.addNewEmployee(new Employee("Станиславов Станислав Станиславович", 3, 1100));
        empBook.addNewEmployee(new Employee("Янов Ян Янович", 3, 7700));
        empBook.addNewEmployee(new Employee("Борисов Борис Борисович", 4, 8800));
        empBook.addNewEmployee(new Employee("Залипупов Залипуп Залипупович", 1, 4400));
        empBook.addNewEmployee(new Employee("Геннадьев Геннадий Геннадиевич", 5, 10000));
        empBook.addNewEmployee(new Employee("Джонатанов Джонатан Джонатанович", 5, 1_000_000));

        System.out.println("Список сотрудников со всеми данными:");
        empBook.printAllEmployees();
        System.out.println();

        System.out.println(empBook.getEmployeeFromId(4));
//        System.out.println(empBook.getEmployeeFromId(43));        // выбросит ошибку, так как нет сотрудника с таким id

        empBook.deleteEmployeeFromId(8);
//        empBook.deleteEmployeeFromId(50);                         // выбросит ошибку, так как нет сотрудника с таким id
        System.out.println();

        System.out.println("Сумма затрат на ЗП в месяц: " + empBook.getSumMonthSalaries());
        System.out.println();

        System.out.println("Сотрудник с минимальной ЗП: " + empBook.getEmployeeWithMinSalary());
        System.out.println();

        System.out.println("Сотрудник с максимальной ЗП: " + empBook.getEmployeeWithMaxSalary());
        System.out.println();

        System.out.printf("Среднее значение ЗП: %.2f\n", empBook.getAverageMonthSalary());
        System.out.println();

        System.out.println("Список ФИО всех сотрудников:");
        empBook.printAllEmployeesFullNames();
        System.out.println();

        int indexValue = 10;
        System.out.printf("Индексируем ЗП сотрудников на %d процентов\n", indexValue);
        empBook.indexSalaries(indexValue);
        System.out.println("Список всех сотрудников:");
        empBook.printAllEmployees();
        System.out.println();

        int department = 3;
        System.out.printf("Сотрудник с минимальной ЗП в отделе %d:\n", department);
        System.out.println(empBook.getEmployeeWithMinSalaryFromDepartment(department));
        System.out.println();

        System.out.printf("Сотрудник с максимальной ЗП в отделе %d:\n", department);
        System.out.println(empBook.getEmployeeWithMaxSalaryFromDepartment(department));
        System.out.println();

        System.out.printf("Сумма затрат на ЗП по отделу %d: %.2f\n", department, empBook.getMonthSalaryFromDepartment(department));
        System.out.println();

        System.out.printf("Средняя ЗП по отделу %d составляет %.2f\n", department, empBook.getAverageMonthSalaryFromDepartment(department));
        System.out.println();

        System.out.printf("Индексируем ЗП сотрудников из отдела %d на %d процентов\n", department, indexValue);
        empBook.indexSalariesFromDepartment(indexValue, department);
        System.out.println("Список всех сотрудников:");
        empBook.printAllEmployees();
        System.out.println();

        System.out.printf("Список сотрудников из отдела %d\n", department);
        empBook.printAllEmployeesFromDepartment(department);
        System.out.println();

        int score = 5000;
        System.out.printf("Список сотрудников с ЗП до %d:\n", score);
        empBook.printEmployeesWithSalaryLessThan(score);
        System.out.println();

        System.out.printf("Список сотрудников с ЗП от %d и выше:\n", score);
        empBook.printEmployeesWithSalaryMoreThan(score);
        System.out.println();
    }




}