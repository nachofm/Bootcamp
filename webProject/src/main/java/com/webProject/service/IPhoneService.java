package com.webProject.service;

import com.globant.webProject.model.Phone;

import java.util.List;

public interface IPhoneService {
    public Phone getPhone(int id);
    public List<Phone> getAllPhones();
    public void createPhone(Phone phone);
    public void modifyPhone(Phone phone, int phone_id);
    public void deletePhone(int phone_id);
}
