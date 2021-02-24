package com.example.colleagueslist;

public class PersonInfo {

    private String name = null, id = null, email = null, institution = null, phone = null;

    public PersonInfo(String name, String email, String institution, String phone) {
        this.name = name;
        this.email = email;
        this.institution = institution;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getInstitution() {
        return institution;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
