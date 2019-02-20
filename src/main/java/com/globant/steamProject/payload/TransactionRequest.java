package com.globant.steamProject.payload;

import javax.validation.Valid;

public class TransactionRequest {

    private long id;
    @Valid
    private long idUser;
    @Valid
    private long idGame;
    @Valid
    private long idMod;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }

    public long getIdMod() {
        return idMod;
    }

    public void setIdMod(long idMod) {
        this.idMod = idMod;
    }
}
