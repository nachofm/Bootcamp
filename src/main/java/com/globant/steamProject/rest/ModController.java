package com.globant.steamProject.rest;

import com.globant.steamProject.model.Game;
import com.globant.steamProject.model.Mod;
import com.globant.steamProject.payload.ModRequest;
import com.globant.steamProject.service.IModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/mods")
public class ModController {

    @Autowired
    IModService modService;

    @PostMapping(path="/addNewMod")
    public @ResponseBody void addNewMod (@Valid @RequestBody ModRequest modRequest) {
        modService.createMod(modRequest);
    }

    @GetMapping(path="/findModById/{id}")
    @Valid
    public @ResponseBody Mod findModById(@PathVariable(value="id") long id)
    {
        return modService.findModById(id);
    }

    @GetMapping(path="/getAllMods")
    public @ResponseBody List<Mod> getAllMods() {
        return modService.getAllMods();
    }


    @PutMapping(path="/modifyMod/{id}")
    public @ResponseBody void modifyMod(@RequestBody ModRequest modRequest, @PathVariable(value="id") long id  ) {
        modService.modifyMod(modRequest,id);

    }

    @PutMapping(path="/deleteMod/{id}")
    public @ResponseBody void deleteMod(@PathVariable(value="id") long id){
        modService.deleteModById(id);
    }

    @GetMapping(path="/getModByName")
    public @ResponseBody Mod getModByName(@RequestBody ModRequest modRequest){
        return modService.findModByName(modRequest.getName());
    }
}
