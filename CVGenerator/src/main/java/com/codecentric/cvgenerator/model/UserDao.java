package com.codecentric.cvgenerator.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.api.entities.User;


@Transactional
public interface UserDao extends CrudRepository<Ausbildung, Long> {

}
