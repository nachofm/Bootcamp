package com.globant.steamProject.model;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class BaseEntity extends Auditable implements Serializable {
    @Id
    @Column(name="id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) //Automatically generated value
    Long id;

    @Column(name="active")
    boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
