package com.codecentric.cvgenerator.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codecentric.cvgenerator.api.entities.Projekte;

public interface ProjekteDao extends CrudRepository<Projekte, Long>{
	
	 @Query("SELECT p From User u JOIN u.projekte p WHERE u.name = :userName") 
	 List<Projekte> findAllProjekteByUserName(@Param("userName") String userName); 
	    
	 @Query("SELECT p From User u JOIN u.projekte p WHERE u.vorname = :userVorname") 
	 List<Projekte> findAllProjekteByUserVorname(@Param("userVorname") String userVorname); 
}
