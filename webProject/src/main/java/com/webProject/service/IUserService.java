package com.webProject.service;

import com.globant.webProject.model.User;

import java.util.List;

public interface IUserService {
    public User getUser(int id);
    public List<User> getAll();
    public void createUser(User user);
    public void modifyUser(User user, int id);
    public void deleteUser(int id);

}
