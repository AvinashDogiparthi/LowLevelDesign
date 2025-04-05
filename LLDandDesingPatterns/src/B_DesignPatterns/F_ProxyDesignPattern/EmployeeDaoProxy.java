package B_DesignPatterns.F_ProxyDesignPattern;

import Z_Exception.DesignException;
import Z_Exception.DesignErrorEnum;

public class EmployeeDaoProxy implements EmployeeDao{
    EmployeeDao employeeDaoObj;

    public EmployeeDaoProxy() {
        this.employeeDaoObj = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDao obj) throws Exception {

        if(client.equalsIgnoreCase("ADMIN")){
            employeeDaoObj.create(client,obj);
            return;
        }

        throw new DesignException(DesignErrorEnum.ACCESS_DENIED,"Used doesn't have create permissions");

    }

    @Override
    public void delete(String client, int employeeId) throws Exception {

        if(client.equalsIgnoreCase("ADMIN")){
            employeeDaoObj.delete(client,employeeId);
            return;
        }

        throw new DesignException(DesignErrorEnum.ACCESS_DENIED,"User doesn't have delete permissions");

    }

    @Override
    public EmployeeDao get(String client, int employeeId) throws Exception {

        if(client.equalsIgnoreCase("ADMIN") || client.equalsIgnoreCase("USER")){
            return employeeDaoObj.get(client,employeeId);
        }

        throw new DesignException(DesignErrorEnum.ACCESS_DENIED,"User doesn't have retrieve permissions");
    }
}
