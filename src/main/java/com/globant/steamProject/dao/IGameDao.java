package com.globant.steamProject.dao;

import com.globant.steamProject.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameDao extends CrudRepository<Game, Long> {
    Game findByName(String name);
}
