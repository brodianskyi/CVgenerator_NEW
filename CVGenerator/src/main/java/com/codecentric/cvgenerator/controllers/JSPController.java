package com.codecentric.cvgenerator.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	 @RequestMapping(value = "/home/findAusbildungenByUserName/{userName}")
     public @ResponseBody User dataUser(@PathVariable("userName") String userName) {
		   
		   List<Ausbildung> list =  ausbildungDao.findAllAusbildungByUserName(userName);
		   User user = new User();
		   user.setAusbildung(list);
	  
	 return user; 	 
   }
	 
	 @RequestMapping(value = "/home/findUserByAusbildungStelle/{ausStelle}")
	 public @ResponseBody User userTest(@PathVariable("ausStelle") String ausStelle) {
		   
		   User user = userDao.findUserByAusbildungStelle(ausStelle);
		   
	   return user; 	 
   }
	  
   
	@RequestMapping(value = "/result", method = RequestMethod.POST)
    public void result(@ModelAttribute("user")User user,
    		@ModelAttribute("ausbildung_helper")AusbildungHelper ausbildungHelper,
    		@ModelAttribute("beruf_helper")BerufHelper berufHelper,	
    		@ModelAttribute("fach_helper")FachHelper fachHelper,
    		@ModelAttribute("projekte_helper")ProjekteHelper projekteHelper,
    		HttpServletRequest request,
    		HttpServletResponse response) throws IOException {
		
	  final ServletContext servletContext = request.getSession().getServletContext();
	  final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
	  final String temperotyFilePath = tempDirectory.getAbsolutePath();
	
	    CreatePDF create_document = new CreatePDF(user,ausbildungHelper,berufHelper,fachHelper,projekteHelper); 
	  
	    String fileName = "JavaHonk.pdf";
	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition", "attachment; filename="+ fileName);

	    try {
	    	Ausbildung ausbildung = null;
	    	Beruf beruf = null;
	    	Fach fach = null;
	    	Projekte projekte = null;
	        create_document.createPDF(temperotyFilePath+"\\"+fileName);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
	        OutputStream os = response.getOutputStream();
	        baos.writeTo(os);
	        for(int i = 0; i < ausbildungHelper.getAusbildung_begin().size(); i++){
	        	
	        	ausbildung = new Ausbildung(ausbildungHelper.getAusbildung_begin().get(i), 
	        			ausbildungHelper.getAusbildung_end().get(i), 
	        			ausbildungHelper.getAusbildung_ort().get(i), 
	        			ausbildungHelper.getAusbildung_stelle().get(i));
	        	        user.addAusbildung(ausbildung); 
	        }
            for(int i = 0; i < berufHelper.getBeruf_begin().size(); i++){
	        	
	        	beruf = new Beruf(berufHelper.getBeruf_begin().get(i),
	        			berufHelper.getBeruf_end().get(i),
	        			berufHelper.getBeruf_stelle().get(i),
	        			berufHelper.getBeruf_position().get(i));
	        	        user.addBeruf(beruf);
	        }
            for(int i = 0; i < fachHelper.getFach_kenntnisse().size(); i++){
	        	
	        	fach = new Fach(fachHelper.getFach_gebiet().get(i),
	        			fachHelper.getFach_kenntnisse().get(i));
	        	        user.addFach(fach);
	        }
            for(int i = 0; i < projekteHelper.getProjekte_begin().size(); i++){
	        	
	        	projekte = new Projekte(projekteHelper.getProjekte_begin().get(i),
	        			 projekteHelper.getProjekte_kunde().get(i),
	        			 projekteHelper.getProjekte_end().get(i),
	        			 projekteHelper.getProjekte_thematik().get(i),
	        			 projekteHelper.getProjekte_rolle().get(i),
	        			 projekteHelper.getProjekte_technologie().get(i));
	        	         user.addProjekte(projekte);
	        }
	        
            user.addProjekte(projekte);
	        addUserData(user);
	        addAusbildungData(user);
	        addFachData(user);
	        addProjekteData(user);
	        
	        os.flush();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    } 
  }
  
	
	public String addUserData(User user) {
		 try {
			 userDao.save(user);
	
		    }catch (Exception e) {
	        	return "Error creating the User Table: " + e.toString();
	        }
		 return "User succesfully created! (id = " + user.getUser_id() + ")"; 
	}
	
	public String addAusbildungData(User user) {
		 try {
			
			 ausbildungDao.save(user.getAusbildung());
			
		    }catch (Exception e) {
	        	return "Error creating Ausbildung Table: " + e.toString();
	        }
		 return "Ausbildung succesfully created!!!"; 
	}
	
	public String addBerufData(User user) {
		 try {
			
			 berufDao.save(user.getBeruf());
			
		    }catch (Exception e) {
	        	return "Error creating Beruf Table: " + e.toString();
	        }
		 return "Beruf succesfully created!!!"; 
	}
	
	public String addFachData(User user) {
		 try {
			
			 fachDao.save(user.getFach());
			
		    }catch (Exception e) {
	        	return "Error creating Fach Table: " + e.toString();
	        }
		 return "Fach succesfully created!!!"; 
	}
  
	public String addProjekteData(User user) {
		 try {
			
			 projekteDao.save(user.getProjekte());
			
			
		    }catch (Exception e) {
	        	return "Error creating Project Table: " + e.toString();
	        }
		 return "Project succesfully created!!!"; 
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
