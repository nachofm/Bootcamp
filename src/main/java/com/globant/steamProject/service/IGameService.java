package com.globant.steamProject.service;

import com.globant.steamProject.model.Game;
import com.globant.steamProject.payload.GameRequest;

import java.util.List;

public interface IGameService {


    public List<Game> getAll();
    public Game findGameById(Long id);
    public Game findGameByName(String name);
    public void save(Game game);
    public void deleteById(Long id);
    public void createGame(GameRequest gameRequest);
    public void modifyGame(GameRequest gameRequest, long id);
}
