package Domain;

import java.util.List;

public class Employee {

    private String employeeNumber;
    private String name;
    private EmploymentType employmentType;
    private String nationality;


    private ContactDetails contactDetails;
    private Address address;


    private List<ID> identities;


    public Employee() {}

    public Employee(String employeeNumber, String name, EmploymentType employmentType, String nationality) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.employmentType = employmentType;
        this.nationality = nationality;
    }

    public String getEmployeeNumber() { return employeeNumber; }
    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public EmploymentType getEmploymentType() { return employmentType; }
    public void setEmploymentType(EmploymentType employmentType) { this.employmentType = employmentType; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public ContactDetails getContactDetails() { return contactDetails; }
    public void setContactDetails(ContactDetails contactDetails) { this.contactDetails = contactDetails; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<ID> getIdentities() { return identities; }
    public void setIdentities(List<ID> identities) { this.identities = identities; }
}


