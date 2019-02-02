package com.globant.webProject.model;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name= "users", schema = "globant")
public class User {
    @Id//Defines pirmary key
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Automatically generated value
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="dni")
    private String dni;

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