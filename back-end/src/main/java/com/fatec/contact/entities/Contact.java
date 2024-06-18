package com.fatec.contact.entities;

public class Contact {

    private Integer id;
    private String name;
    private String email;
    private String Sex;
    private String Choose;
    private String phone;
    private String type;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSex() {
        return Sex;
    }
    public void setSex(String sex) {
        Sex = sex;
    }
    public String getChoose() {
        return Choose;
    }
    public void setChoose(String choose) {
        Choose = choose;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
