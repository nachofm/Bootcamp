package com.globant.steamProject.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "user", schema = "steam")
@Where(clause="active=1")
public class User extends BaseNamedEntity{

    @ManyToMany(cascade = CascadeType.ALL)
    //the persistence will propagate (cascade) all EntityManager operations to the relating entities.
    @JoinTable(
            name="transactions",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="item_id", referencedColumnName="ID"))
    private List<Item> items;

    public User(){}

    public User(List<Item> items) {
        this.items = items;
    }

    public User(String name, List<Item> items) {
        super(name);
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
