package com.webProject.rest;

import com.webProject.model.Phone;

import com.webProject.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    IPhoneService phoneService;

    @GetMapping(path="/getPhone/{phone_id}")
    public @ResponseBody Phone getPhone(@PathVariable(value="phone_id") int id) {
        // This returns a JSON or XML with the users
        return phoneService.getPhone(id);
    }

    @GetMapping(path="/getAllPhones")
    public @ResponseBody List<Phone> getAllPhones() {
        // This returns a JSON or XML with the users
        return phoneService.getAllPhones();
    }

    @PostMapping(path="/addPhone")
    public @ResponseBody String addNewPhone (@Valid @RequestBody Phone phone) {
        phoneService.createPhone(phone);
        return "Saved phone "  + phone.getId();
    }

    @PutMapping(path="/modifyPhone/{phone_id}")
    public @ResponseBody String modifyPhone (@Valid @RequestBody  Phone phone, @PathVariable(value="phone_id") int phone_id){
        phoneService.modifyPhone(phone, phone_id);
        return "Modified phone " + phone_id;
    }

    @DeleteMapping(path="/deletePhone/{phone_id}")
    public @ResponseBody String deleteUserById(@PathVariable(value="phone_id") int phone_id){
        phoneService.deletePhone(phone_id);
        return "Deleted phone " + phone_id;
    }
}
