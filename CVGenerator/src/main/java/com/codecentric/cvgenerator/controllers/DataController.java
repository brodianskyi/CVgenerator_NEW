package com.codecentric.cvgenerator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.model.AusbildungDao;
import com.codecentric.cvgenerator.model.BerufDao;
import com.codecentric.cvgenerator.model.FachDao;
import com.codecentric.cvgenerator.model.ProjekteDao;
import com.codecentric.cvgenerator.model.UserDao;

@Controller
@RequestMapping(value= "/data")
public class DataController {
	 @Autowired
	 private UserDao userDao;
	 @Autowired
	 private AusbildungDao ausbildungDao;
	 @Autowired
	 private BerufDao berufDao;
	 @Autowired
	 private FachDao fachDao;
	 @Autowired
	 private ProjekteDao projekteDao;
	
   
	 @RequestMapping(value = "/findAusbildungenByUserName/{userName}")
     public @ResponseBody User findAusbildungenByUserName(@PathVariable("userName") String userName) {
		   
		   List<Ausbildung> list =  ausbildungDao.findAllAusbildungByUserName(userName);
		   User user = new User();
		   user.setAusbildung(list);
	  
	 return user; 	 
   }
	 
	 @RequestMapping(value = "/findAusbildungenByUserVorname/{userVorname}")
     public @ResponseBody User findAusbildungenByUserVorname(@PathVariable("userVorname") String userVorname) {
		   
		   List<Ausbildung> list =  ausbildungDao.findAllAusbildungByUserVorname(userVorname);
		   User user = new User();
		   user.setAusbildung(list);
	  
	 return user; 	 
   }
	 @RequestMapping(value = "/findUserByAusbildungOrt/{ausOrt}")
	 public @ResponseBody User findUserByAusbildungOrt(@PathVariable("ausOrt") String ausOrt) {
		   
		   User user = userDao.findUserByAusbildungOrt(ausOrt);
		   
	   return user; 	 
   }
	 
	 @RequestMapping(value = "/findUserByAusbildungBegin/{ausBegin}")
	 public @ResponseBody User findUserByAusbildungBegin(@PathVariable("ausBegin") String ausBegin) {
		   
		   User user = userDao.findUserByAusbildungBegin(ausBegin);
		   
	   return user; 	 
   }
	 
	 @RequestMapping(value = "/findUserByAusbildungEnd/{ausEnd}")
	 public @ResponseBody User findUserByAusbildungEnd(@PathVariable("ausEnd") String ausEnd) {
		   
		   User user = userDao.findUserByAusbildungEnd(ausEnd);
		   
	   return user; 	 
   }
	 
	 @RequestMapping(value = "/findUserByAusbildungStelle/{ausStelle}")
	 public @ResponseBody User findUserByAusbildungStelle(@PathVariable("ausStelle") String ausStelle) {
		   
		   User user = userDao.findUserByAusbildungStelle(ausStelle);
		   
	   return user; 	 
   }
	 
	 
	 
	 
	 
	 
	
}
