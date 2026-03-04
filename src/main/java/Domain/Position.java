package Domain;

public class Position {


    private String positionCode;
    private PositionStatus status;


    public Position() {}

    public Position(String positionCode, PositionStatus status) {
        this.positionCode = positionCode;
        this.status = status;
    }

    public String getPositionCode() { return positionCode; }
    public void setPositionCode(String positionCode) { this.positionCode = positionCode; }

    public PositionStatus getStatus() { return status; }
    public void setStatus(PositionStatus status) { this.status = status; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

}
