package com.ewis;

public class Member {
    private int id;
    private String name;
    private String email;

    //Constructor
    public Member(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email =email;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
