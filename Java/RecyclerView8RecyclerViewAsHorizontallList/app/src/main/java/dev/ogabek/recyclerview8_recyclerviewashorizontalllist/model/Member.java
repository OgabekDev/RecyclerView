package dev.ogabek.recyclerview8_recyclerviewashorizontalllist.model;

public class Member {

    private int id;
    private String name, surname;

    public Member(int id, String name, String surname) {

        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setId(int id) {
        this.id = id;
    }

}
