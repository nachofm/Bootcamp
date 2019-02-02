package com.globant.webProject.service;

import com.globant.webProject.dao.IUserDao;
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
        return userDao.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userDao.findAll();
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

    }

    @Override
    public void deleteUser(int id) {
        if (userDao.findById(id).isPresent()){
        userDao.deleteById(id);
        }

    }
}
