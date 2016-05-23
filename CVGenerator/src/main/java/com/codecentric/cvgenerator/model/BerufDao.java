package com.codecentric.cvgenerator.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codecentric.cvgenerator.api.entities.Beruf;

public interface BerufDao extends CrudRepository<Beruf, Long> {

	@Query("SELECT b From User u JOIN u.beruf b WHERE u.name = :userName")
	List<Beruf> findAllBerufByUserName(@Param("userName") String userName);

	@Query("SELECT b From User u JOIN u.beruf b WHERE u.vorname = :userVorname")
	List<Beruf> findAllBerufByUserVorname(@Param("userVorname") String userVorname);

}
