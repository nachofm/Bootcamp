package com.globant.steamProject.dao;

import com.globant.steamProject.model.Mod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModDao extends CrudRepository<Mod, Long> {
    Mod findByName(String name);
}
