package com.globant.steamProject.service;

import com.globant.steamProject.dao.IGameDao;
import com.globant.steamProject.dao.IModDao;
import com.globant.steamProject.dao.IUserDao;
import com.globant.steamProject.exceptions.ResourceException;
import com.globant.steamProject.model.*;
import com.globant.steamProject.payload.TransactionRequest;
import com.globant.steamProject.payload.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@SuppressWarnings("Duplicates")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Autowired
    IGameDao gameDao;

    @Autowired
    IModDao modDao;

    @Override
    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setActive(true);
        return userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        List<User> users = (List<User>) userDao.findAll();
        if (!users.isEmpty())
        {
            return users;
        }
        else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "List is empty.");
        }

    }

    @Override
    public User findUserById(Long id) {
        User user = userDao.findById(id).orElse(null);
        if (user != null)
        {
            return user;
        }
        else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the user.");
        }
    }

    @Override
    public User findUserByName(String name) {

        User user = userDao.findByName(name);
        if (user != null)
        {
            return user;
        }
        else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the user.");
        }

    }


    @Override
    public void deleteById(Long id) {

            User user = userDao.findById(id).orElseThrow
                    (()->new ResourceException(HttpStatus.NOT_FOUND, "User not found."));
            user.setActive(false);
            user.setId(id);
            userDao.save(user);


    }

    @Override
    public User modifyUser(UserRequest userRequest, long id) {
        if (userDao.findById(id).isPresent()) {

            User user = userDao.findById(id).get();
            user.setName(userRequest.getName());
            user.setActive(true);
            return userDao.save(user);

        }
        else
        {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the user.");
        }


    }

    @Override
    public void saveGameTransaction(TransactionRequest transactionRequest) {
        User user = userDao.findById(transactionRequest.getIdUser()).orElse(null);
        Game game = gameDao.findById(transactionRequest.getIdGame()).orElse(null);

        if(user != null && game != null && user.isActive() && game.isActive())
        {
            user.getItems().add(game);
            userDao.save(user);
            throw new ResourceException(HttpStatus.OK, "Transaction successful.");
        }
        else
        {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the user/game.");

        }

    }

    @Override
    public void saveModTransaction(TransactionRequest transactionRequest) {
        User user = userDao.findById(transactionRequest.getIdUser()).orElse(null);
        Mod mod = modDao.findById(transactionRequest.getIdMod()).orElse(null);

        if(user != null && mod != null && user.isActive() && mod.isActive())
        {
            user.getItems().add(mod);
            userDao.save(user);
            throw new ResourceException(HttpStatus.OK, "Transaction successful.");
        }
        else
        {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the user/mod.");
        }

    }
}







