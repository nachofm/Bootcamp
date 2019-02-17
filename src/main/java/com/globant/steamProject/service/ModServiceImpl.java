package com.globant.steamProject.service;

import com.globant.steamProject.dao.IGameDao;
import com.globant.steamProject.dao.IModDao;
import com.globant.steamProject.exceptions.ResourceException;
import com.globant.steamProject.model.Description;
import com.globant.steamProject.model.Game;
import com.globant.steamProject.model.Mod;
import com.globant.steamProject.payload.ModRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("Duplicates")
public class ModServiceImpl implements IModService {

    @Autowired
    private IModDao modDao;

    @Autowired
    private IGameDao gameDao;


    @Override
    public List<Mod> getAllMods() {

        List<Mod> mods = (List<Mod>) modDao.findAll();
        if (!mods.isEmpty()) {
            return mods;
        } else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "List is empty.");
        }
    }


    @Override
    public Mod findModById(Long id) {
        Mod mod = modDao.findById(id).orElse(null);
        if (mod != null)
        {
            return mod;
        }
        else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the mod.");
        }

    }

    @Override
    public Mod findModByName(String name) {
        Mod mod = modDao.findByName(name);
        if (mod != null)
        {
            return mod;
        }
        else {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the mod.");
        }
    }

    @Override
    public void save(Mod mod) {
        modDao.save(mod);

    }

    @Override
    public void deleteModById(Long id) {
        if (modDao.findById(id).isPresent()){
            Mod mod = modDao.findById(id).orElse(null);
            mod.setActive(false);
            mod.setId(id);
            modDao.save(mod);
            throw new ResourceException(HttpStatus.OK, "Mod deleted successfuly.");
        }
        else
        {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the mod.");
        }

    }

    @Override
    public void createMod(ModRequest modRequest) {
        Game game = gameDao.findById(modRequest.getIdGame()).orElse(null);
        if(game == null)
        {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the mod.");
        }
        else
        {
        Mod mod = new Mod();
        Description description = new Description();

        description.setMobileDescription(modRequest.getMobileDescription());
        description.setWebDescription(modRequest.getWebDescription());
        mod.setDescription(description);

        mod.setGame(game);
        mod.setName(modRequest.getName());
        mod.setActive(true);
        modDao.save(mod);
        throw new ResourceException(HttpStatus.OK, "Mod saved successfuly.");
        }

    }


    @Override
    public void modifyMod(ModRequest modRequest, long id) {
        if (modDao.findById(id).isPresent()) {

            Mod mod = modDao.findById(id).get();
            mod.setName(modRequest.getName());
            modDao.save(mod);
            throw new ResourceException(HttpStatus.OK, "Mod modified successfuly.");
        }
        else
        {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the mod.");
        }

    }
}
