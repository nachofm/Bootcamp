package com.globant.steamProject.service;

import com.globant.steamProject.dao.IGameDao;
import com.globant.steamProject.exceptions.ResourceException;
import com.globant.steamProject.model.Description;
import com.globant.steamProject.model.Game;
import com.globant.steamProject.payload.GameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    private IGameDao gameDao;

    @Override
    public Game createGame(GameRequest gameRequest) {
        Game game = new Game();
        game.setName(gameRequest.getName());
        Description description = new Description();
        description.setMobileDescription(gameRequest.getMobileDescription());
        description.setWebDescription(gameRequest.getWebDescription());
        game.setDescription(description);
        game.setActive(true);
        return gameDao.save(game);
    }

    @Override
    public Game modifyGame(GameRequest gameRequest, long id) {
        if (gameDao.findById(id).isPresent()) {
            Game game = gameDao.findById(id).get();
            Description description = new Description();
            game.setName(gameRequest.getName());

            description.setMobileDescription(gameRequest.getMobileDescription());
            description.setWebDescription(gameRequest.getWebDescription());
            game.setDescription(description);
            game.setActive(true);

            return gameDao.save(game);
        }
        else
        {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the game.");
        }

    }

    @Override
    public List<Game> getAll() {
        List<Game> games = (List<Game>) gameDao.findAll();
        if (!games.isEmpty())
        {
            return games;
        }
        else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "List is empty.");
        }
    }

    @Override
    public Game findGameById(Long id) {
        Game game = gameDao.findById(id).orElse(null);
        if (game != null)
        {
            return game;
        }
        else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the game.");
        }
    }

    @Override
    public Game findGameByName(String name) {
        Game game = gameDao.findByName(name);
        if (game != null)
        {
            return game;
        }
        else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the game.");
        }

    }


    @Override
    public void deleteById(Long id) {
        if (gameDao.findById(id).isPresent()){
            Game game = gameDao.findById(id).orElse(null);
            game.setActive(false);
            game.setId(id);
            gameDao.save(game);
            throw new ResourceException(HttpStatus.OK, "Game deleted successfuly.");
        }
        else
        {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the game.");
        }

    }


}
