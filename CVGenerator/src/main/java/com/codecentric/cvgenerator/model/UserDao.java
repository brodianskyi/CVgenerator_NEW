package com.codecentric.cvgenerator.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.api.entities.User;


//@Transactional
public interface UserDao extends CrudRepository<User, Long> {
	
	@Query("SELECT u From Ausbildung a JOIN a.user u WHERE a.ausbildung_stelle = :ausbildungStelle")
    User findUserByAusbildungStelle(@Param("ausbildungStelle") String ausbildungStelle);
}
