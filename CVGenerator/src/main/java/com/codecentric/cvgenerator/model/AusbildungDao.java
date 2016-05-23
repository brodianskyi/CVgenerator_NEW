package com.codecentric.cvgenerator.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codecentric.cvgenerator.api.entities.Ausbildung;

public interface AusbildungDao extends CrudRepository<Ausbildung, Long> {

	@Query("SELECT a From User u JOIN u.ausbildung a WHERE u.name = :userName")
	List<Ausbildung> findAllAusbildungByUserName(@Param("userName") String userName);

	@Query("SELECT a From User u JOIN u.ausbildung a WHERE u.vorname = :userVorname")
	List<Ausbildung> findAllAusbildungByUserVorname(@Param("userVorname") String userVorname);

}
