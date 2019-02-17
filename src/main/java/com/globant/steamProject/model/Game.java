package com.globant.steamProject.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "game", schema = "steam")
public class Game extends Item {

    @OneToMany(targetEntity=Mod.class, mappedBy="game", fetch=FetchType.EAGER)
    @Column(name="mods")
    List<Mod> mods;

    public Game(){}

    public Game(List<User> users, Description description, List<Mod> mods) {
        super(users, description);
        this.mods = mods;
    }

    public Game(String name, List<User> users, Description description, List<Mod> mods) {
        super(name, users, description);
        this.mods = mods;
    }

    public List<Mod> getMods() {
        return mods;
    }

    public void setMods(List<Mod> mods) {
        this.mods = mods;
    }
}
