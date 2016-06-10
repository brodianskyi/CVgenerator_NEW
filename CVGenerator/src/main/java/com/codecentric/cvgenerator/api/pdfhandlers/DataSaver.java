package com.codecentric.cvgenerator.api.pdfhandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.model.AusbildungDao;
import com.codecentric.cvgenerator.model.BerufDao;
import com.codecentric.cvgenerator.model.FachDao;
import com.codecentric.cvgenerator.model.ProjekteDao;
import com.codecentric.cvgenerator.model.UserDao;

public class DataSaver {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

/*	public String addUserData(User user, UserDao userDao) {
		try {
			userDao.save(user);

		} catch (Exception e) {
			return "Error creating the User Table: " + e.toString();
		}
		return "User succesfully created! (id = " + user.getUser_id() + ")";
	}

	public String addAusbildungData(User user, AusbildungDao ausbildungDao) {
		try {

			ausbildungDao.save(user.getAusbildung());

		} catch (Exception e) {
			return "Error creating Ausbildung Table: " + e.toString();
		}
		return "Ausbildung succesfully created!!!";
	}

	public String addBerufData(User user, BerufDao berufDao) {
		try {

			berufDao.save(user.getBeruf());

		} catch (Exception e) {
			return "Error creating Beruf Table: " + e.toString();
		}
		return "Beruf succesfully created!!!";
	}

	public String addFachData(User user, FachDao fachDao) {
		try {

			fachDao.save(user.getFach());

		} catch (Exception e) {
			return "Error creating Fach Table: " + e.toString();
		}
		return "Fach succesfully created!!!";
	}

	public String addProjekteData(User user, ProjekteDao projekteDao) {
		try {

			projekteDao.save(user.getProjekte());

		} catch (Exception e) {
			return "Error creating Project Table: " + e.toString();
		}
		return "Project succesfully created!!!";
	}
*/
}
