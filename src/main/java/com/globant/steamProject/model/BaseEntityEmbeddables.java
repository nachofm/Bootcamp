package com.globant.steamProject.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class BaseEntityEmbeddables{

    @Column(name="id", insertable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    public BaseEntityEmbeddables (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
