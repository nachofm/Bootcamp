package com.globant.steamProject.payload;

public class ModRequest {

    private long id;
    private String name;
    private String mobileDescription;
    private String webDescription;
    private long idGame;

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

    public String getMobileDescription() {
        return mobileDescription;
    }

    public void setMobileDescription(String mobileDescription) {
        this.mobileDescription = mobileDescription;
    }

    public String getWebDescription() {
        return webDescription;
    }

    public void setWebDescription(String webDescription) {
        this.webDescription = webDescription;
    }

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }
}
