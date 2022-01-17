package dev.ogabek.recyclerview6_recyclerviewinsidenedtedscrollview.model;

public class Member {

    private String name;
    private String telephoneNumber;

    public Member(String name, String telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public void setName(String name) {
        this.name = name;
    }

}
