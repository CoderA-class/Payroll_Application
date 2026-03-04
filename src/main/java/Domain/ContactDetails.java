package Domain;

import java.util.ConcurrentModificationException;

public class ContactDetails {

    private String cellPhone;
    private String email;
    private String homePhone;

    public ContactDetails(){}

    public ContactDetails(String cellPhone , String email , String homePhone){
        this.cellPhone = cellPhone;
        this.email =  email;
        this.homePhone = homePhone;

    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
