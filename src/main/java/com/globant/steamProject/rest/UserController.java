package com.globant.steamProject.rest;

import com.globant.steamProject.model.User;
import com.globant.steamProject.payload.TransactionRequest;
import com.globant.steamProject.payload.UserRequest;
import com.globant.steamProject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping(path="/addNewUser")
    public @ResponseBody void addNewUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);

    }

    @GetMapping("/getAllUsers")
    public @ResponseBody Iterable<User> getAllUsers(){
        return  userService.getAll();
    }

    @GetMapping(path="/findById/{id}")
    public @ResponseBody User getUserById(@PathVariable(value="id") long id) {

        return userService.findUserById(id);
    }

    @PutMapping("/deleteUserById/{id}")
    public @ResponseBody void DeleteUserById(@PathVariable(value="id") long id ) {
            userService.deleteById(id);
    }


    @PutMapping(path="/modifyUser/{id}")
    public @ResponseBody void UpdateUser(@RequestBody UserRequest userRequest, @PathVariable(value="id") long id  ) {
            userService.modifyUser(userRequest,id);

    }


    @GetMapping(path="/getUserByName")
    public @ResponseBody User getByName(@RequestBody UserRequest userRequest){
        return userService.findUserByName(userRequest.getName());
    }

    @PostMapping(path="/addGame")
    public @ResponseBody void addGameToUser(@RequestBody TransactionRequest transactionRequest)
    {
        userService.saveGameTransaction(transactionRequest);
    }

    @PostMapping(path="/addMod")
    public @ResponseBody void addModToUser(@RequestBody TransactionRequest transactionRequest)
    {
        userService.saveModTransaction(transactionRequest);
    }

}
