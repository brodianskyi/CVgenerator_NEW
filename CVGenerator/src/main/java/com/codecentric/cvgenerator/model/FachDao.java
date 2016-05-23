package com.codecentric.cvgenerator.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codecentric.cvgenerator.api.entities.Fach;

public interface FachDao extends CrudRepository<Fach, Long> {

	@Query("SELECT f From User u JOIN u.fach f WHERE u.name = :userName")
	List<Fach> findAllFachByUserName(@Param("userName") String userName);

	@Query("SELECT f From User u JOIN u.fach f WHERE u.vorname = :userVorname")
	List<Fach> findAllFachByUserVorname(@Param("userVorname") String userVorname);
}
