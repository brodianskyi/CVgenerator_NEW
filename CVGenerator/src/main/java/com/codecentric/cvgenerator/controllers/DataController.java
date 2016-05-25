package com.codecentric.cvgenerator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.api.entities.Beruf;
import com.codecentric.cvgenerator.api.entities.Fach;
import com.codecentric.cvgenerator.api.entities.Projekte;
import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.model.AusbildungDao;
import com.codecentric.cvgenerator.model.BerufDao;
import com.codecentric.cvgenerator.model.FachDao;
import com.codecentric.cvgenerator.model.ProjekteDao;
import com.codecentric.cvgenerator.model.UserDao;

@Controller
@RequestMapping(value = "/data")
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

	@RequestMapping(value = "/findAusbildungenByUserName/{userName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody User findAusbildungenByUserName(@PathVariable("userName") String userName) {

		List<Ausbildung> list = ausbildungDao.findAllAusbildungByUserName(userName);
		User user = new User();
		user.setAusbildung(list);

		return user;
	}

	@RequestMapping(value = "/findAusbildungenByUserVorname/{userVorname}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody User findAusbildungenByUserVorname(@PathVariable("userVorname") String userVorname) {

		List<Ausbildung> list = ausbildungDao.findAllAusbildungByUserVorname(userVorname);
		User user = new User();
		user.setAusbildung(list);

		return user;
	}

	@RequestMapping(value = "/findAllBerufByUserName/{userName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody User findAllBerufByUserName(@PathVariable("userName") String userName) {

		List<Beruf> list = berufDao.findAllBerufByUserName(userName);
		User user = new User();
		user.setBeruf(list);

		return user;
	}

	@RequestMapping(value = "/findAllBerufByUserVorname/{userVorname}")
	public @ResponseBody User findAllBerufByUserVorname(@PathVariable("userVorname") String userVorname) {

		List<Beruf> list = berufDao.findAllBerufByUserVorname(userVorname);
		User user = new User();
		user.setBeruf(list);

		return user;
	}

	@RequestMapping(value = "/findAllFachByUserName/{userName}")
	public @ResponseBody User findAllFachByUserName(@PathVariable("userName") String userName) {

		List<Fach> list = fachDao.findAllFachByUserName(userName);
		User user = new User();
		user.setFach(list);

		return user;
	}

	@RequestMapping(value = "/findAllFachByUserVorname/{userVorname}")
	public @ResponseBody User findAllFachByUserVorname(@PathVariable("userVorname") String userVorname) {

		List<Fach> list = fachDao.findAllFachByUserVorname(userVorname);
		User user = new User();
		user.setFach(list);

		return user;
	}

	@RequestMapping(value = "/findAllProjekteByUserName/{userName}")
	public @ResponseBody User findAllProjekteByUserName(@PathVariable("userName") String userName) {

		List<Projekte> list = projekteDao.findAllProjekteByUserName(userName);
		User user = new User();
		user.setProjekte(list);

		return user;
	}

	@RequestMapping(value = "/findAllProjekteByUserVorname/{userVorname}")
	public @ResponseBody User findAllProjekteByUserVorname(@PathVariable("userVorname") String userVorname) {

		List<Projekte> list = projekteDao.findAllProjekteByUserVorname(userVorname);
		User user = new User();
		user.setProjekte(list);

		return user;
	}

	@RequestMapping(value = "/findUserByAusbildungOrt/{ausOrt}")
	public @ResponseBody User findUserByAusbildungOrt(@PathVariable("ausOrt") String ausOrt) {

		User user = userDao.findUserByAusbildungOrt(ausOrt);

		return user;
	}

	@RequestMapping(value = "/findUserByAusbildungStelle/{ausStelle}")
	public @ResponseBody User findUserByAusbildungStelle(@PathVariable("ausStelle") String ausStelle) {

		User user = userDao.findUserByAusbildungStelle(ausStelle);

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

	@RequestMapping(value = "/findUserByBerufPosition/{berufPosition}")
	public @ResponseBody User findUserByBerufPosition(@PathVariable("berufPosition") String berufPosition) {

		User user = userDao.findUserByBerufPosition(berufPosition);

		return user;
	}

	@RequestMapping(value = "/findUserByBerufStelle/{berufStelle}")
	public @ResponseBody User findUserByBerufStelle(@PathVariable("berufStelle") String berufStelle) {

		User user = userDao.findUserByBerufStelle(berufStelle);

		return user;
	}

	@RequestMapping(value = "/findUserByBerufBegin/{berufBegin}")
	public @ResponseBody User findUserByBerufBegin(@PathVariable("berufBegin") String berufBegin) {

		User user = userDao.findUserByBerufBegin(berufBegin);

		return user;
	}

	@RequestMapping(value = "/findUserByBerufEnd/{berufEnd}")
	public @ResponseBody User findUserByBerufEnd(@PathVariable("berufEnd") String berufEnd) {

		User user = userDao.findUserByBerufEnd(berufEnd);

		return user;
	}

	@RequestMapping(value = "/findUserByFachGebiet/{fachGebiet}")
	public @ResponseBody User findUserByFachGebiet(@PathVariable("fachGebiet") String fachGebiet) {

		User user = userDao.findUserByFachGebiet(fachGebiet);

		return user;
	}

	@RequestMapping(value = "/findUserByFachKenntnisse/{fachKenntnisse}")
	public @ResponseBody User findUserByFachKenntnisse(@PathVariable("fachKenntnisse") String fachKenntnisse) {

		User user = userDao.findUserByFachKenntnisse(fachKenntnisse);

		return user;
	}

	@RequestMapping(value = "/findUserByProjekteBegin/{projekteBegin}")
	public @ResponseBody User findUserByProjekteBegin(@PathVariable("projekteBegin") String projekteBegin) {

		User user = userDao.findUserByProjekteBegin(projekteBegin);

		return user;
	}

	@RequestMapping(value = "/findUserByProjekteEnd/{projekteEnd}")
	public @ResponseBody User findUserByProjekteEnd(@PathVariable("projekteEnd") String projekteEnd) {

		User user = userDao.findUserByProjekteEnd(projekteEnd);

		return user;
	}

	@RequestMapping(value = "/findUserByProjekteKunde/{projekteKunde}")
	public @ResponseBody User findUserByProjekteKunde(@PathVariable("projekteKunde") String projekteKunde) {

		User user = userDao.findUserByProjekteKunde(projekteKunde);

		return user;
	}

	@RequestMapping(value = "/findUserByProjekteRolle/{projekteRolle}")
	public @ResponseBody User findUserByProjekteRolle(@PathVariable("projekteRolle") String projekteRolle) {

		User user = userDao.findUserByProjekteRolle(projekteRolle);

		return user;
	}

	@RequestMapping(value = "/findUserByProjekteTechnologie/{projekteTechnologie}")
	public @ResponseBody User findUserByProjekteTechnologie(
			@PathVariable("projekteTechnologie") String projekteTechnologie) {

		User user = userDao.findUserByProjekteTechnologie(projekteTechnologie);

		return user;
	}

	@RequestMapping(value = "/findUserByProjekteThematik/{projekteThematik}")
	public @ResponseBody User findUserByProjekteThematik(@PathVariable("projekteThematik") String projekteThematik) {

		User user = userDao.findUserByProjekteThematik(projekteThematik);

		return user;
	}

}
