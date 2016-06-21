package com.codecentric.cvgenerator.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.api.entities.Beruf;
import com.codecentric.cvgenerator.api.entities.Fach;
import com.codecentric.cvgenerator.api.entities.Projekte;
import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.api.entities.helpers.AusbildungHelper;
import com.codecentric.cvgenerator.api.entities.helpers.BerufHelper;
import com.codecentric.cvgenerator.api.entities.helpers.FachHelper;
import com.codecentric.cvgenerator.api.entities.helpers.ProjekteHelper;
import com.codecentric.cvgenerator.api.pdfhandlers.CreatePDF;
import com.codecentric.cvgenerator.api.pdfhandlers.DataSaver;
import com.codecentric.cvgenerator.model.AusbildungDao;
import com.codecentric.cvgenerator.model.BerufDao;
import com.codecentric.cvgenerator.model.FachDao;
import com.codecentric.cvgenerator.model.ProjekteDao;
import com.codecentric.cvgenerator.model.UserDao;

@Controller
public class JSPController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
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
	
	@RequestMapping("/home")
	public ModelAndView jspSpringboot() {

		logger.info("Hey man if you see this !!!");
		ModelAndView modelAndView = new ModelAndView("jsp-spring-boot");

		return modelAndView;
	}

	@RequestMapping("/test")
	public ModelAndView jspSpringboot_test() {

		ModelAndView modelAndView = new ModelAndView("test");

		return modelAndView;
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public void result(@ModelAttribute("user") User user,
			@ModelAttribute("ausbildung_helper") AusbildungHelper ausbildungHelper,
			@ModelAttribute("beruf_helper") BerufHelper berufHelper,
			@ModelAttribute("fach_helper") FachHelper fachHelper,
			@ModelAttribute("projekte_helper") ProjekteHelper projekteHelper, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		final ServletContext servletContext = request.getSession().getServletContext();
		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
        
		
		CreatePDF create_document = new CreatePDF(user, ausbildungHelper, berufHelper, fachHelper, projekteHelper);

		String fileName = "MyCV.pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);

		try {
			Ausbildung ausbildung = null;
			Beruf beruf = null;
			Fach fach = null;
			Projekte projekte = null;
			ArrayList<String> buff = new ArrayList<String>();
			
            String ausbildung_click=(String) request.getParameter("ausbildung_click");
            if (ausbildung_click != null){
				logger.info("Don't press the red button!!!");
			} 
			else {
				 String ausbildung_stelle =(String) request.getParameter("ausbildung_stelle");
				 buff.add(ausbildung_stelle);
				 ausbildungHelper.setAusbildung_stelle(buff);
				 buff.clear();
				 String ausbildung_ort = (String) request.getParameter("ausbildung_ort");
			     buff.add(ausbildung_ort);
			     ausbildungHelper.setAusbildung_ort(buff);
			}
			for (int i = 0; i < ausbildungHelper.getAusbildung_begin().size(); i++) {
				 ausbildung = new Ausbildung(ausbildungHelper.getAusbildung_begin().get(i),
				 ausbildungHelper.getAusbildung_end().get(i), 
				 ausbildungHelper.getAusbildung_ort().get(i),
				 ausbildungHelper.getAusbildung_stelle().get(i));
				 user.addAusbildung(ausbildung); 
			}
			
			String beruf_click=(String) request.getParameter("beruf_click");
			if (beruf_click != null){
				logger.info("Don't press the red button!!!");
			} 
			else {
				 String beruf_stelle =(String) request.getParameter("beruf_stelle");
				 buff.clear();
				 buff.add(beruf_stelle);
				 berufHelper.setBeruf_stelle(buff);
				 buff.clear();
				 String beruf_position = (String) request.getParameter("beruf_position");
			     buff.add(beruf_position);
			     berufHelper.setBeruf_position(buff);
			    }
			for (int i = 0; i < berufHelper.getBeruf_begin().size(); i++) {
                 beruf = new Beruf(berufHelper.getBeruf_begin().get(i), 
				 berufHelper.getBeruf_end().get(i),
				 berufHelper.getBeruf_stelle().get(i), 
				 berufHelper.getBeruf_position().get(i));
				 user.addBeruf(beruf);
			}
			
			String fach_click=(String) request.getParameter("fach_click");
			if (fach_click != null){
				logger.info("Don't press the red button!!!");
			} 
			else {
				 String fach_gebiet =(String) request.getParameter("fach_gebiet");
				 buff.clear();
				 buff.add(fach_gebiet);
				 fachHelper.setFach_gebiet(buff);
				 buff.clear();
				 String fach_kenntnisse = (String) request.getParameter("fach_kenntnisse");
			     buff.add(fach_kenntnisse);
			     fachHelper.setFach_kenntnisse(buff);
			     }
			for (int i = 0; i < fachHelper.getFach_kenntnisse().size(); i++) {
                 fach = new Fach(fachHelper.getFach_gebiet().get(i), 
                 fachHelper.getFach_kenntnisse().get(i));
				 user.addFach(fach);
			}
			
			
			String projekte_click=(String) request.getParameter("projekte_click");
			if (projekte_click != null){
				logger.info("Don't press the red button!!!");
			} 
			else {
				 String projekte_kunde = (String) request.getParameter("projekte_kunde");
				 buff.clear();
				 buff.add(projekte_kunde);
				 projekteHelper.setProjekte_kunde(buff);
				 buff.clear();
				 String projekte_thematik = (String) request.getParameter("projekte_thematik");
				 buff.clear();
				 buff.add(projekte_thematik);
				 projekteHelper.setProjekte_thematik(buff);
				 buff.clear();
				 String projekte_rolle = (String) request.getParameter("projekte_rolle");
				 buff.clear();
				 buff.add(projekte_rolle);
				 projekteHelper.setProjekte_rolle(buff);
				 buff.clear();
				 String projekte_technologie = (String) request.getParameter("projekte_technologie");
				 buff.clear();
				 buff.add(projekte_technologie);
				 projekteHelper.setProjekte_technologie(buff);
		        }
		    for (int i = 0; i < projekteHelper.getProjekte_begin().size(); i++) {
                 projekte = new Projekte(projekteHelper.getProjekte_begin().get(i),
				 projekteHelper.getProjekte_kunde().get(i), 
				 projekteHelper.getProjekte_end().get(i),
				 projekteHelper.getProjekte_thematik().get(i), 
				 projekteHelper.getProjekte_rolle().get(i),
				 projekteHelper.getProjekte_technologie().get(i));
				 user.addProjekte(projekte);
			}
			create_document.createPDF(temperotyFilePath + "\\" + fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			DataSaver dataSaver = new DataSaver();
			dataSaver.addUserData(user, userDao);
			dataSaver.addAusbildungData(user, ausbildungDao);
			dataSaver.addBerufData(user, berufDao);
			dataSaver.addFachData(user, fachDao);
			dataSaver.addProjekteData(user, projekteDao);
       
			os.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	

	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

}
