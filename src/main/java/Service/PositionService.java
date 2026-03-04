package Service;


import Domain.Employee;
import Domain.Position;
import Domain.PositionStatus;
import Repo.EmployeeRepo;
import Repo.JobRepo;
import Repo.PositionRepo;

public class PositionService {

    private final PositionRepo positionRepository;
    private final JobRepo jobRepository;
    private final EmployeeRepo employeeRepository;

    public PositionService(PositionRepo positionRepository,
                           JobRepo jobRepository,
                           EmployeeRepo employeeRepository) {
        this.positionRepository = positionRepository;
        this.jobRepository = jobRepository;
        this.employeeRepository = employeeRepository;
    }

    public Position createPosition(Position p, String jobTitle) {
        if (p == null) throw new IllegalArgumentException("Position cannot be null");
        if (jobRepository.findByTitle(jobTitle) == null)
            throw new RuntimeException("Job not found: " + jobTitle);
        return positionRepository.save(p);
    }

    public Position updatePosition(Position p) {
        if (p == null) throw new IllegalArgumentException("Position cannot be null");
        Position existing = positionRepository.findByPositionCode(p.getPositionCode());
        if (existing == null) throw new RuntimeException("Position not found: " + p.getPositionCode());
        return positionRepository.save(p);
    }

    public Position findPositionByCode(String code) {
        if (code == null || code.isBlank()) throw new IllegalArgumentException("Position code cannot be blank");
        return positionRepository.findByPositionCode(code);
    }

    public void assignEmployeeToPosition(String empNo, String positionCode) {
        Employee employee = employeeRepository.findByEmployeeNumber(empNo);
        if (employee == null) throw new RuntimeException("Employee not found: " + empNo);

        Position position = positionRepository.findByPositionCode(positionCode);
        if (position == null) throw new RuntimeException("Position not found: " + positionCode);

        position.setEmployee(employee);
        positionRepository.save(position);
    }

    public void openPosition(String positionCode) {
        Position position = positionRepository.findByPositionCode(positionCode);
        if (position == null) throw new RuntimeException("Position not found: " + positionCode);
        position.setStatus(PositionStatus.OPEN);
        positionRepository.save(position);
    }

    public void closePosition(String positionCode) {
        Position position = positionRepository.findByPositionCode(positionCode);
        if (position == null) throw new RuntimeException("Position not found: " + positionCode);
        position.setStatus(PositionStatus.CLOSED);
        positionRepository.save(position);
    }
}