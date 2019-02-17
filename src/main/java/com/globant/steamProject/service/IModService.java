package com.globant.steamProject.service;

import com.globant.steamProject.model.Mod;
import com.globant.steamProject.payload.ModRequest;

import java.util.List;

public interface IModService {

    public List<Mod> getAllMods();
    public Mod findModById(Long id);
    public Mod findModByName(String name);
    public void save(Mod mod);
    public void deleteModById(Long id);
    public void createMod(ModRequest modRequest);
    public void modifyMod(ModRequest modRequest, long id);
}
