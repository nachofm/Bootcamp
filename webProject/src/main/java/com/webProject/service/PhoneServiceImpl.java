package com.webProject.service;

import com.globant.webProject.dao.IPhoneDao;
import com.webProject.exceptions.BadRequestException;
import com.globant.webProject.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhoneServiceImpl implements IPhoneService{

    @Autowired
    private IPhoneDao phoneDao;

    @Override
    public Phone getPhone(int id) {

        if (phoneDao.findById(id).isPresent()){
            return phoneDao.findById(id).get();
        }
        else{

            String code ="001";
            String message = "Wrong phone id.";
            throw new BadRequestException(code,message);

        }
    }

    @Override
    public List<Phone> getAllPhones() {
        if ((List<Phone>) phoneDao.findAll() == null)
        {
            String code ="002";
            String message = "Phone list is null.";
            throw new BadRequestException(code,message);
        }
        else
        {
            return (List<Phone>) phoneDao.findAll();
        }

    }

    @Override
    public void createPhone(Phone phone) {
        phoneDao.save(phone);

    }

    @Override
    public void modifyPhone(Phone phone, int phone_id) {
        if (phoneDao.findById(phone_id).isPresent()){
            phone.setId(phone_id);
            phoneDao.save(phone);
        }

        else
        {
            String code ="003";
            String message = "Phone does not exist.";
            throw new BadRequestException(code,message);
        }

    }

    @Override
    public void deletePhone(int phone_id) {
        if (phoneDao.findById(phone_id).isPresent()){
            phoneDao.deleteById(phone_id);
        }
        else
        {
            String code ="004";
            String message = "Phone does not exist.";
            throw new BadRequestException(code,message);

        }

    }
}

