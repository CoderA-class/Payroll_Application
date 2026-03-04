package Domain;




import Repo.EmployeeRepo;
import Repo.JobRepo;
import Repo.PositionRepo;
import Service.EmployeeService;
import Service.JobService;
import Service.PositionService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // --- In-memory repository implementations (for demo purposes) ---
        EmployeeRepo employeeRepository = new InMemoryEmployeeRepository();
        JobRepo jobRepository = new InMemoryJobRepository();
        PositionRepo positionRepository = new InMemoryPositionRepository();

        // --- Wire up services ---
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        JobService jobService = new JobService(jobRepository);
        PositionService positionService = new PositionService(positionRepository, jobRepository, employeeRepository);

        // --- Create an Employee ---
        Employee employee = new Employee("EMP001", "John Doe", EmploymentType.PERMANENT, "South African");

        ContactDetails contact = new ContactDetails("0821234567", "john.doe@email.com", "0112345678");
        employee.setContactDetails(contact);

        Address address = new Address("123 Main Street, Johannesburg", "PO Box 456, Johannesburg, 2000");
        employee.setAddress(address);

        List<ID> identities = new ArrayList<>();
        boolean id = identities.add(new ID("ID", "8001015009087"));
        employee.setIdentities(identities);

        employeeService.createEmployee(employee);
        System.out.println("Employee created: " + employee.getName());

        // --- Create a Job ---
        JobTitle job = new JobTitle("Software Engineer");
        jobService.createJob(job);
        System.out.println("Job created: " + job.getTitle());

        // --- Create a Position ---
        Position position = new Position("POS001", PositionStatus.OPEN);
        positionService.createPosition(position, "Software Engineer");
        System.out.println("Position created: " + position.getPositionCode() + " | Status: " + position.getStatus());

        // --- Assign Employee to Position ---
        positionService.assignEmployeeToPosition("EMP001", "POS001");
        System.out.println("Employee EMP001 assigned to Position POS001");

        // --- Close the Position ---
        positionService.closePosition("POS001");
        Position updated = positionService.findPositionByCode("POS001");
        System.out.println("Position status after closing: " + updated.getStatus());

        // --- Find Employee ---
        Employee found = employeeService.findEmployeeByNumber("EMP001");
        System.out.println("Found employee: " + found.getName() + " | Type: " + found.getEmploymentType());
    }


    // =====================================================================
    // Simple in-memory repository implementations for demo/testing purposes
    // =====================================================================

    static class InMemoryEmployeeRepository implements EmployeeRepo {
        private final List<Employee> store = new ArrayList<>();

        @Override
        public Employee save(Employee e) {
            store.removeIf(emp -> emp.getEmployeeNumber().equals(e.getEmployeeNumber()));
            store.add(e);
            return e;
        }

        @Override
        public Employee findByEmployeeNumber(String empNo) {
            return store.stream()
                    .filter(e -> e.getEmployeeNumber().equals(empNo))
                    .findFirst().orElse(null);
        }

        @Override
        public List<Employee> findAll() { return new ArrayList<>(store); }

        @Override
        public void deleteByEmployeeNumber(String empNo) {
            store.removeIf(e -> e.getEmployeeNumber().equals(empNo));
        }
    }

    static class InMemoryJobRepository implements JobRepo {
        private final List<JobTitle> store = new ArrayList<>();

        @Override
        public JobTitle save(JobTitle j) {
            store.removeIf(job -> job.getTitle().equals(j.getTitle()));
            store.add(j);
            return j;
        }

        @Override
        public JobTitle findByTitle(String title) {
            return store.stream()
                    .filter(j -> j.getTitle().equals(title))
                    .findFirst().orElse(null);
        }

        @Override
        public List<JobTitle> findAll() { return new ArrayList<>(store); }

        @Override
        public void deleteByTitle(String title) {
            store.removeIf(j -> j.getTitle().equals(title));
        }
    }

    static class InMemoryPositionRepository implements PositionRepo {
        private final List<Position> store = new ArrayList<>();

        @Override
        public Position save(Position p) {
            store.removeIf(pos -> pos.getPositionCode().equals(p.getPositionCode()));
            store.add(p);
            return p;
        }

        @Override
        public Position findByPositionCode(String code) {
            return store.stream()
                    .filter(p -> p.getPositionCode().equals(code))
                    .findFirst().orElse(null);
        }

        @Override
        public List<Position> findAllByJobTitle(String title) {
            return new ArrayList<>(store); // simplified for demo
        }

        @Override
        public void deleteByPositionCode(String code) {
            store.removeIf(p -> p.getPositionCode().equals(code));
        }
    }
}