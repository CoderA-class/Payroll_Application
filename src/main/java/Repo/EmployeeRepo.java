package Repo;



import Domain.Employee;

import java.util.List;

public interface EmployeeRepo {

    Employee save(Employee e);

    Employee findByEmployeeNumber(String empNo);

    List<Employee> findAll();

    void deleteByEmployeeNumber(String empNo);
}
