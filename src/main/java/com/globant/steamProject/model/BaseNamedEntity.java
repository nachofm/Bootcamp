package com.globant.steamProject.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;


@MappedSuperclass
public abstract class BaseNamedEntity extends BaseEntity{
    @Column(name="name")
    String name;

    public BaseNamedEntity(){}

    public BaseNamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
