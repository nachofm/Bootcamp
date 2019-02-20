package com.globant.steamProject.dao;

import com.globant.steamProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {

    User findByName(String name);

}
