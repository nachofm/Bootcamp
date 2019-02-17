package com.globant.steamProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "mods", schema = "steam")
@Where(clause="active=1")
public class Mod extends Item {


    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", referencedColumnName="id")
    @JsonIgnore
    public Game game;

    public Mod(){}

    public Mod(Game game) {
        this.game = game;
    }

    public Mod(List<User> users, Description description, Game game) {
        super(users, description);
        this.game = game;
    }

    public Mod(String name, List<User> users, Description description, Game game) {
        super(name, users, description);
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
