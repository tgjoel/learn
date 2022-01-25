package concepts.designpatterns.builder;

public class EmployeeMainClass {

    public static void main(String[] args) {
        Employee employee = new Employee().setAddress("qaz").setId(1).setName("joel");
        System.out.println(employee.toString());
    }
}
