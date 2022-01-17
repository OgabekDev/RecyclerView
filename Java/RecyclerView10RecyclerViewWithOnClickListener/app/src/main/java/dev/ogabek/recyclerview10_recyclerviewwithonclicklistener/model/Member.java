package dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.model;

public class Member {

    private String id,  name, telephoneNumber;

    public Member(int id, String name, String telephoneNumber) {
        this.id = String.valueOf(id);
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
