package com.globant.steamProject.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

//https://stackoverflow.com/questions/49281385/java-javax-embeded-entity-with-springboot-and-vaadin-cant-make-a-column



@Embeddable
//se mapea en la misma tabla que lo extiende
public class Description extends BaseEntityEmbeddables
{

    @Column(name="webDescription")
    String webDescription;
    @Column(name="mobileDescription")
    String mobileDescription;

    public Description (){}

    public Description(String webDescription, String mobileDescription) {
        this.webDescription = webDescription;
        this.mobileDescription = mobileDescription;
    }

    public String getWebDescription() {
        return webDescription;
    }

    public void setWebDescription(String webDescription) {
        this.webDescription = webDescription;
    }

    public String getMobileDescription() {
        return mobileDescription;
    }

    public void setMobileDescription(String mobileDescription) {
        this.mobileDescription = mobileDescription;
    }
}