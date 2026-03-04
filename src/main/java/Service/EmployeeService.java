package Service;


import Domain.Employee;
import Repo.EmployeeRepo;

public class EmployeeService {

    private final EmployeeRepo employeeRepository;

    public EmployeeService(EmployeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee e) {
        if (e == null) throw new IllegalArgumentException("Employee cannot be null");
        return employeeRepository.save(e);
    }

    public Employee updateEmployee(Employee e) {
        if (e == null) throw new IllegalArgumentException("Employee cannot be null");
        Employee existing = employeeRepository.findByEmployeeNumber(e.getEmployeeNumber());
        if (existing == null) throw new RuntimeException("Employee not found: " + e.getEmployeeNumber());
        return employeeRepository.save(e);
    }

    public Employee findEmployeeByNumber(String empNo) {
        if (empNo == null || empNo.isBlank()) throw new IllegalArgumentException("Employee number cannot be blank");
        return employeeRepository.findByEmployeeNumber(empNo);
    }
}