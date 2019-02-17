package com.globant.steamProject.dao;

import com.globant.steamProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {
    /*@Query("select id, created_at, updated_at, active, name from users where active = activeValue")
    public List<User> findAll(@Param("activeValue") boolean activeValue);

    @Modifying
    @Query("SELECT id, created_at, updated_at, active, name FROM user WHERE user.active = :activeValue")
    List<User> findAll(@Param("activeValue") boolean activeValue);*/

    User findByName(String name);

}
