package com.globant.webProject.dao;
import com.globant.webProject.model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneDao extends CrudRepository<Phone, Integer>{
}
