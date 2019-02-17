package com.webProject.service;

import com.globant.webProject.dao.IUserDao;
import com.webProject.exceptions.BadRequestException;
import com.globant.webProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    @Override
    public User getUser(int id) {
        if (userDao.findById(id).isPresent()){
            return userDao.findById(id).get();
        }
        else{

            String code ="001";
            String message = "Wrong user id.";
            throw new BadRequestException(code,message);

        }

    }

    @Override
    public List<User> getAll() {
        if ((List<User>) userDao.findAll() == null)
        {
            String code ="002";
            String message = "List is null.";
            throw new BadRequestException(code,message);
        }
        else
        {
            return (List<User>) userDao.findAll();
        }

    }

    @Override
    public void createUser(User user) {
        userDao.save(user);
    }

    @Override
    public void modifyUser(User user, int id) {
        if (userDao.findById(id).isPresent()){
            user.setId(id);
            userDao.save(user);
        }
        else
        {
            String code ="003";
            String message = "User does not exist.";
            throw new BadRequestException(code,message);
        }

    }

    @Override
    public void deleteUser(int id) {
        if (userDao.findById(id).isPresent()){
        userDao.deleteById(id);
        }
        else
        {
            String code ="004";
            String message = "User does not exist.";
            throw new BadRequestException(code,message);

        }


    }

}
