package Domain;



public class Address {

    private String streetAddress;
    private String postalAddress;

    public Address(){

    }
    public  Address(String streetAddress , String postalAddress){
        this.streetAddress = streetAddress;
        this.postalAddress = postalAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
}
