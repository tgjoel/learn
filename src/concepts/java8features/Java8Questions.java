package concepts.java8features;

import concepts.java8features.model.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Questions {
    static List<Employee> employeeList = Employee.getEmployeeList();
    public static void main(String[] args) {

        // Query 1 : How many male and female employees are there in the organization?
        method1();
        // Query 2 : Print the name of all departments in the organization?
        method2();
        // Query 3 : What is the average age of male and female employees?
        method3();
        // Query 4 : Get the details of highest paid employee in the organization?
        method4();
        // Query 5 : Get the names of all employees who have joined after 2015?
        method5();
        // Query 6 : Count the number of employees in each department?
        method6();
        // Query 7 : What is the average salary of each department?
        method7();
        // Query 8 : Get the details of youngest male employee in the product development department?
        method8();
        // Query 9 : Who has the most working experience in the organization?
        method9();
        // Query 10 : How many male and female employees are there in the sales and marketing team?
        method10();
        // Query 11 : What is the average salary of male and female employees?
        method11();
        // Query 12 : List down the names of all employees in each department?
        method12();
        // Query 13 : What is the average salary and total salary of the whole organization?
        method13();
        // Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        method14();
        // Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        method15();
        //Grouping by multiple properties
        method16();
        //grouping by multiple and getting the list
        method17();
        //custom comparator
        method18();
    }

    private static void method18() {
        Comparator<Employee> compareByName1 = (ob1,ob2) -> ob1.getName().compareTo(ob2.getName());
        Comparator<Employee> compareByName2 = Comparator.comparing(Employee::getName);
        employeeList.sort(compareByName1);
    }

    private static void method17() {
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.groupingBy(Employee::getGender))));
    }

    private static void method16() {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.groupingBy(Employee::getGender, Collectors.counting())));
    }

    private static int maximum(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    private static void method15() {
        employeeList.stream().max(Comparator.comparingInt(Employee::getAge))
                .ifPresent(employee -> System.out.println("Name: " + employee.getName() + " || Department: " + employee.getDepartment()));
    }

    private static void method14() {
        Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 25));
        //if key is true then value contains the list of employees > 25
        //if key is false then value contains the list of emplyes <=25;
    }

    private static void method13() {
        DoubleSummaryStatistics doubleStat = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        doubleStat.getAverage();
        doubleStat.getSum();
    }

    private static void method12() {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
    }

    private static void method11() {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
    }

    private static void method10() {
        Predicate<Employee> departPredicate = employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing");
        employeeList.stream().filter(departPredicate).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
    }

    private static void method9() {
        Optional<Employee> employeeOptional = employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining));
        //employeeOptional.ifPresent(employee -> System.out.println(employee.getName()));
    }

    private static void method8() {
       Predicate<Employee> productDevelopment = (employee) -> employee.getDepartment().equalsIgnoreCase("Product Development");
       Predicate<Employee> genderPredicate = employee -> employee.getGender().equalsIgnoreCase("Male");
        employeeList.stream()
                .filter(productDevelopment.and(genderPredicate))
                .min(Comparator.comparingInt(Employee::getAge));
    }

    private static void method7() {
        Map<String, Double> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        collect.forEach((k,v) -> {
          //  System.out.println(k + " : " + v);
        });
    }

    private static void method6() {
       employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    private static void method5() {
        employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName)
                .collect(Collectors.toList());
    }

    private static void method4() {
        //if more than one records then finds the one coming first
        employeeList.stream().max(Comparator.comparing(Employee::getSalary));
    }

    private static void method3() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge)));
    }

    private static void method2() {
       // employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    }

    private static void method1() {
        Map<String,Long> countMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

    }
}
