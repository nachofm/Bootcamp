package com.globant.steamProject.service;

import com.globant.steamProject.model.User;
import com.globant.steamProject.payload.TransactionRequest;
import com.globant.steamProject.payload.UserRequest;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IUserService {


    public List<User> getAll();
    public User findUserById(Long id);
    public User findUserByName(String name);
    public void save(User user);
    public void deleteById(Long id);
    public void createUser(UserRequest userRequest);
    public void modifyUser(UserRequest userRequest, long id);
    public HttpStatus saveGameTransaction(TransactionRequest transactionRequest);
    public void saveModTransaction(TransactionRequest transactionRequest);
}
