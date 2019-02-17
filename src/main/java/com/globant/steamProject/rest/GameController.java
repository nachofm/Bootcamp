package com.globant.steamProject.rest;

import com.globant.steamProject.model.Game;
import com.globant.steamProject.model.User;
import com.globant.steamProject.payload.GameRequest;
import com.globant.steamProject.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/games")
public class GameController {

    @Autowired
    IGameService gameService;

    @PostMapping(path="/addNewGame")
    public @ResponseBody void addNewGame(@RequestBody GameRequest gameRequest) {
        gameService.createGame(gameRequest);
    }

    @GetMapping("/getAllGames")
    public @ResponseBody Iterable<Game> getAllGames(){
        return gameService.getAll();
    }

    @GetMapping(path="/findById/{id}")
    public @ResponseBody Game getGameById(@PathVariable(value="id") long id) {
        return gameService.findGameById(id);
    }

    @PutMapping("/deleteGame")
    public @ResponseBody void DeleteGameById(@RequestBody GameRequest gameRequest ) {
        gameService.deleteById(gameRequest.getId());
    }


    @PutMapping(path="/modifyGame/{id}")
    public @ResponseBody void modifyGame(@RequestBody GameRequest gameRequest, @PathVariable(value="id") long id  ) {
        gameService.modifyGame(gameRequest,id);
    }

    @GetMapping(path="/getGameByName")
    public @ResponseBody Game getGameByName(@RequestBody GameRequest gameRequest){
        return gameService.findGameByName(gameRequest.getName());
    }
}
