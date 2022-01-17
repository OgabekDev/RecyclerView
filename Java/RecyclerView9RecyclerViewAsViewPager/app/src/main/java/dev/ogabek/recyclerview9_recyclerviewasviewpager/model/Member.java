package dev.ogabek.recyclerview9_recyclerviewasviewpager.model;

public class Member {

    private String name;
    private String id;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = String .valueOf(id);
    }
    public void setName(String name) {
        this.name = name;
    }

    public Member(String name, int id) {
        this.name = name;
        this.id = String.valueOf(id);
    }

}
