package com.globant.steamProject.payload;

import javax.validation.Valid;

public class UserRequest {

    private long id;
    @Valid
    private String name;
    @Valid
    private Long item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }
}

