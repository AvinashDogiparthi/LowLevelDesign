package B_DesignPatterns.F_ProxyDesignPattern;

public interface EmployeeDao {

    public void create(String client, EmployeeDao obj) throws Exception;
    public void delete(String client, int employeeId) throws Exception;
    public EmployeeDao get(String client, int employeeId) throws Exception;
}
