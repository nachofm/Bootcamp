package com.globant.webProject.model;
import javax.persistence.*;
import java.util.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name= "users", schema = "globant")
public class User {
    @Id//Defines pirmary key
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Automatically generated value
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="dni")
    private String dni;

    /**
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "phone_user")
    private List<Phone> phones = new ArrayList<Phone>();

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Phone> getPhones() {
        return phones;
    }
    **/

    public void setDni(String dni) { this.dni = dni;}

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDni() { return dni; }

    public Integer getId() { return id; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}