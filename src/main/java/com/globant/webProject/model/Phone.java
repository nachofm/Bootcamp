package com.globant.webProject.model;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name= "phones", schema = "globant")
public class Phone {
    @Id//Defines pirmary key
    @Column(name="phone_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Automatically generated value
    private Integer id;
    @Column(name="number")
    private Integer number;
    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User phone_user;


    public Phone (){
        this.number = null;
        this.description = null;
        this.phone_user = null;
    }


    public Phone(Integer number, String description, User phone_user) {
        this.number = number;
        this.description = description;
        this.phone_user = phone_user;

    }

    public void setPhone_user(User phone_user) {
        this.phone_user = phone_user;
    }

    public User getPhone_user() {

        return phone_user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {

        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
