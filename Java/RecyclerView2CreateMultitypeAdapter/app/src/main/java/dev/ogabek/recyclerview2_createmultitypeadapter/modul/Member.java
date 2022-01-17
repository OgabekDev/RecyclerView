package dev.ogabek.recyclerview2_createmultitypeadapter.modul;

public class Member {

    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private boolean available;

    public Member(String firstName, String lastName, String telephoneNumber, boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.available = available;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

}
