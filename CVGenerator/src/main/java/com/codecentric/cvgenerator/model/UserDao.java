package com.codecentric.cvgenerator.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.api.entities.User;


public interface UserDao extends CrudRepository<User, Long> {
	
    //Ausbildung
	@Query("SELECT u From Ausbildung a JOIN a.user u WHERE a.ausbildung_ort = :ausbildungOrt")
    User findUserByAusbildungOrt(@Param("ausbildungOrt") String ausbildungStelle);
	
	@Query("SELECT u From Ausbildung a JOIN a.user u WHERE a.ausbildung_stelle = :ausbildungStelle")
    User findUserByAusbildungStelle(@Param("ausbildungStelle") String ausbildungStelle);

	@Query("SELECT u From Ausbildung a JOIN a.user u WHERE a.ausbildung_begin = :ausbildungBegin")
	User findUserByAusbildungBegin(@Param("ausbildungBegin")String ausbildungBegin);

	@Query("SELECT u From Ausbildung a JOIN a.user u WHERE a.ausbildung_end = :ausbildungEnd")
	User findUserByAusbildungEnd(@Param("ausbildungEnd")String ausbildungEnd); 
	
	//Beruf
	@Query("SELECT u From Beruf b JOIN b.user u WHERE b.beruf_position = :berufPosition")
	User findUserByBerufPosition(@Param("berufPosition")String berufPosition); 
	
	@Query("SELECT u From Beruf b JOIN b.user u WHERE b.beruf_stelle = :berufStelle")
	User findUserByBerufStelle(@Param("berufStelle")String berufStelle);
	
	@Query("SELECT u From Beruf b JOIN b.user u WHERE b.beruf_begin = :berufBegin")
	User findUserByBerufBegin(@Param("berufBegin")String berufBegin); 
	
	@Query("SELECT u From Beruf b JOIN b.user u WHERE b.beruf_end = :berufEnd")
	User findUserByBerufEnd(@Param("berufEnd")String berufEnd);
	
	//Fach
	@Query("SELECT u From Fach f JOIN f.user u WHERE f.fach_gebiet = :fachGebiet")
	User findUserByFachGebiet(@Param("fachGebiet")String fachGebiet);
	
	@Query("SELECT u From Fach f JOIN f.user u WHERE f.fach_kenntnisse = :fachKenntnisse")
	User findUserByFachKenntnisse(@Param("fachKenntnisse")String fachKenntnisse);
	
	//Projekte
	@Query("SELECT u From Projekte p JOIN p.user u WHERE p.projekte_begin = :projekteBegin")
	User findUserByProjekteBegin(@Param("projekteBegin")String projekteBegin);
	
	@Query("SELECT u From Projekte p JOIN p.user u WHERE p.projekte_end= :projekteEnd")
	User findUserByProjekteEnd(@Param("projekteEnd")String projekteEnd);
	
	@Query("SELECT u From Projekte p JOIN p.user u WHERE p.projekte_kunde = :projekteKunde")
	User findUserByProjekteKunde(@Param("projekteKunde")String projekteKunde);
	
	@Query("SELECT u From Projekte p JOIN p.user u WHERE p.projekte_rolle = :projekteRolle")
	User findUserByProjekteRolle(@Param("projekteRolle")String projekteRolle);
	
	@Query("SELECT u From Projekte p JOIN p.user u WHERE p.projekte_technologie = :projekteTechnologie")
	User findUserByProjekteTechnologie(@Param("projekteTechnologie")String projekteTechnologie);
	
	@Query("SELECT u From Projekte p JOIN p.user u WHERE p.projekte_thematik = :projekteThematik")
	User findUserByProjekteThematik(@Param("projekteThematik")String projekteThematik);

	
	
}