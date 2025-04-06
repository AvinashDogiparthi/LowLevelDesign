package B_DesignPatterns.F_ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao{


    @Override
    public void create(String client, EmployeeDao obj) throws Exception {
        System.out.println("Creating a new row in the employee table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("Deleting a row in the employee table");
    }

    @Override
    public EmployeeDao get(String client, int employeeId) throws Exception {
        System.out.println("Retrieving a row in the employee table");
        return new EmployeeDaoImpl();
    }
}
