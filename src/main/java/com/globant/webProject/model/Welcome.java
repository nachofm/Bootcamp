package com.globant.webProject.model;

public class Welcome {
    private String enterprise;
    private String name;

    public Welcome(String name, String enterprise) {
        this.name = name;
        this.enterprise = enterprise;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public String getName() {
        return name;
    }


}
