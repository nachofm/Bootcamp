package com.webProject.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
@Table(name= "phones", schema = "globant")
public class Phone {
    @Id//Defines pirmary key
    @Column(name="phone_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Automatically generated value
    private Integer id;
    @Column(name="number")
    @Positive
    @Min(20)
    private Long number;
    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    public User phone_user;


    public Phone (){
        this.number = null;
        this.description = null;
        this.phone_user = null;
    }


    public Phone(Long number, String description, User phone_user) {
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

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {

        return id;
    }

    public Long getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
