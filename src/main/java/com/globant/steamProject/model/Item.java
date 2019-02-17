package com.globant.steamProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Where(clause="active=1")
public abstract class Item extends BaseNamedEntity{

    @JsonIgnore
    @ManyToMany(mappedBy="items")
    private List<User> users;

    @Embedded
    @Column(name="descrption")
    Description description;

    public Item(){}

    public Item(List<User> users, Description description) {
        this.users = users;
        this.description = description;
    }

    public Item(String name, List<User> users, Description description) {
        super(name);
        this.users = users;
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
