package B_DesignPatterns.F_ProxyDesignPattern;

public class Main {

    public static void main(String[] args){
        try{
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.create("USER",new EmployeeDo());
            System.out.println("Operation Successful");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
