import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Employee user1 = new Employee("Saulius", "Petrauskas", 1000.5);
        user1.setSalary(777.77);
        user1.setName("Antanas");
//      EmployeeDAO.insert(user1);

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList = EmployeeDAO.searchById(5);
        Employee user = employeeList.get(0);

        user.setName("Antanas2");
        //EmployeeDAO.edit(user);

        EmployeeDAO.delete(5);

    }
}
