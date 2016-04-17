package com.codecentric.cvgenerator.api.pdfhandlers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.utils.stringutils.StringTokenizer;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 23,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
	private StringTokenizer stringTokenizer = new StringTokenizer();
    private User user;
	/**
	 * @param args
	 */
	
	public CreatePDF(User user){
		 this.user = user;
	}
	
	public Document createPDF(String file) {

		Document document = null;

		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			addMetaData(document);

			addPerson(document);

		//	addAusbildung(document);
			
		//	addBeruf(document);
			
		//	addFachkenntnisse(document);
			
			addProjecte(document);

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("Java Honk");
		document.addCreator("Java Honk");
		
		
	}

	private void addPerson(Document document)
			throws DocumentException {
		
        
        Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Zur Person", TIME_ROMAN));

		creteEmptyLine(preface, 1);

		preface.add(new Paragraph("Geburtsdatum "
				+ "         " + user.getGeburtsdatum(),TIME_ROMAN_SMALL ));
		
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Nationalität"
				+ "         " + user.getNationalitaet(), TIME_ROMAN_SMALL));
		
		preface.add(new Paragraph("Telefon"
				+ "         " + user.getTelefon(), TIME_ROMAN_SMALL));
		
		preface.add(new Paragraph("Email"
				+ "         " + user.getTelefon(), TIME_ROMAN_SMALL));
	 
		document.add(preface);
		

	}
	
	private void addAusbildung(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
	
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Ausbildung und Berufserfahrung", TIME_ROMAN));
		creteEmptyLine(preface, 1);
			
		Map<Integer, String> map_for_datum1 = stringTokenizer.getCommaValues(user.getAusbildung_datum_1());
		Map<Integer, String> map_for_datum2 = stringTokenizer.getCommaValues(user.getAusbildung_datum_2());
		Map<Integer, String> map_for_ort = stringTokenizer.getCommaValues(user.getAusbildung_ort());
		Map<Integer, String> map_for_stelle = stringTokenizer.getCommaValues(user.getAusbildung_stelle());
		
		for(int i=1;i < map_for_datum1.size()+1;i++){
			
			preface.add(new Paragraph(map_for_datum1.get(i) + " - "+ map_for_datum2.get(i) +
					"          " + map_for_ort.get(i),TIME_ROMAN_SMALL));
			creteEmptyLine(preface, 1);
			preface.add(new Paragraph(
		    "                  " + map_for_stelle.get(i), TIME_ROMAN_SMALL));
		
		    creteEmptyLine(preface, 1);
		}
			
		document.add(preface);
		
	}
	
	private void addBeruf(Document document)
	        throws DocumentException{
		
		Paragraph preface = new Paragraph();
        creteEmptyLine(preface, 1);
        
    	Map<Integer, String> map_for_beruf_datum1 = stringTokenizer.getCommaValues(user.getBeruf_datum_1());
		Map<Integer, String> map_for_beruf_datum2 = stringTokenizer.getCommaValues(user.getBeruf_datum_2());
		Map<Integer, String> map_for_ort = stringTokenizer.getCommaValues(user.getBeruf_ort());
		Map<Integer, String> map_for_stelle = stringTokenizer.getCommaValues(user.getBeruf_stelle());
    /*    
		for(int i=1;i < map_for_beruf_datum1.size()+1;i++){
		preface.add(new Paragraph(map_for_beruf_datum1.get(i)+ " - "+ map_for_beruf_datum2.get(i) +
				"          " + map_for_ort.get(i),TIME_ROMAN_SMALL));
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph(
	    "                  " + map_for_stelle.get(i), TIME_ROMAN_SMALL));
		document.add(preface);
		} */
	 }
	
	
	private void addFachkenntnisse(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		
		Map<Integer, String> map_for_fach_gebiet = stringTokenizer.getCommaValues(user.getFach_gebiet());
		Map<Integer, String> map_for_fach_kenntnisse = stringTokenizer.getCommaValues(user.getFach_kenntnisse());
		
		preface.add(new Paragraph("Fachkenntnisse", TIME_ROMAN));
		
		creteEmptyLine(preface, 1);
		for(int i=1;i < map_for_fach_gebiet.size()+1;i++){
		preface.add(new Paragraph(map_for_fach_gebiet.get(i)
				+ "         " + map_for_fach_kenntnisse.get(i) , TIME_ROMAN_SMALL));
		creteEmptyLine(preface, 1);
		}
		
		document.add(preface);
	}
	
	private void addProjecte(Document document)
	       throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Projekte(Auszug)", TIME_ROMAN));
		creteEmptyLine(preface, 1);
	
		Map<Integer, String> map_for_projekt_datum1 = stringTokenizer.getCommaValues(user.getProjekte_datum1());
			
		
		Map<Integer, String> map_for_projekt_datum2 = stringTokenizer.getCommaValues(user.getProjekte_datum2());
        Map<Integer, String> map_for_kunde = stringTokenizer.getCommaValues(user.getProjekte_kunde());
     	Map<Integer, String> map_for_thematik = stringTokenizer.getCommaValues(user.getProjekte_thematik());
     	
     	Map<Integer, String> map_for_rolle = stringTokenizer.getCommaValues(user.getProjekte_rolle());
     	Map<Integer, String> map_for_technologie = stringTokenizer.getCommaValues(user.getProjekte_technologie());
     
     	
	//	 for (Map.Entry<Integer, String> entry : map_for_rolle.entrySet()) {
	//	      logger.info("Pasha value" + entry.getKey()+" : "+entry.getValue());
	//	    }
		
  /*		for(int i=1;i < map_for_project_datum1.size()+1;i++){
		preface.add(new Paragraph(map_for_project_datum1.get(i) + " - "
				+ "      " + "Kunde" + map_for_kunde.get(i) , TIME_ROMAN_SMALL));
		preface.add(new Paragraph(map_for_project_datum2.get(i)  
				+ "      " + "Thematik" + map_for_thematik.get(i) , TIME_ROMAN_SMALL));
		preface.add(new Paragraph("Rolle" 
				+ "      " + map_for_rolle.get(i) , TIME_ROMAN_SMALL));
		preface.add(new Paragraph("Technologie" 
				+ "      " + map_for_technologie.get(i) , TIME_ROMAN_SMALL));
		} */
		document.add(preface);
		
	}

	private void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
	private void addTable(Document document)
	      throws DocumentException {
		
	}
	
	

	

}
